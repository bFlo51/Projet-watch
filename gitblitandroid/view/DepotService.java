package com.example.dark.gitblitandroid.view;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Xml;
import com.example.dark.gitblitandroid.dao.GitblitWatchDAOSQLite;
import com.example.dark.gitblitandroid.model.Commit;
import com.example.dark.gitblitandroid.model.Depot;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class DepotService
  extends IntentService
{
  public static final String DONE_DEPOT = "done_depot";
  SSLContext sslContext = null;
  
  public DepotService()
  {
    super("...");
  }
  
  public DepotService(String paramString)
  {
    super(paramString);
  }
  
  private SSLContext createSSLContext(String paramString, int paramInt)
    throws Exception
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(getResources().openRawResource(paramInt));
    try
    {
      Certificate localCertificate = CertificateFactory.getInstance("X.509").generateCertificate(localBufferedInputStream);
      Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject).load(null);
      ((KeyStore)localObject).setCertificateEntry(paramString, localCertificate);
      paramString = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      paramString.init((KeyStore)localObject);
      localObject = SSLContext.getInstance("TLS");
      ((SSLContext)localObject).init(null, paramString.getTrustManagers(), null);
      return (SSLContext)localObject;
    }
    finally
    {
      localBufferedInputStream.close();
    }
  }
  
  private ArrayList<Commit> parseCommitsXml(InputStream paramInputStream)
    throws IOException, XmlPullParserException
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, null);
    Object localObject1 = null;
    int i = localXmlPullParser.getEventType();
    paramInputStream = null;
    if (i != 1)
    {
      Object localObject2 = localObject1;
      Object localObject3 = paramInputStream;
      switch (i)
      {
      default: 
        localObject3 = paramInputStream;
        localObject2 = localObject1;
      }
      for (;;)
      {
        i = localXmlPullParser.next();
        localObject1 = localObject2;
        paramInputStream = (InputStream)localObject3;
        break;
        localObject2 = new ArrayList();
        localObject3 = paramInputStream;
        continue;
        String str = localXmlPullParser.getName();
        if (str.equals("item"))
        {
          localObject3 = new Commit();
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          localObject3 = paramInputStream;
          if (paramInputStream != null) {
            if (str.equals("title"))
            {
              paramInputStream.setDescription(localXmlPullParser.nextText());
              localObject2 = localObject1;
              localObject3 = paramInputStream;
            }
            else if (str.equals("creator"))
            {
              paramInputStream.setDevelopper(localXmlPullParser.nextText());
              localObject2 = localObject1;
              localObject3 = paramInputStream;
            }
            else if (str.equals("date"))
            {
              paramInputStream.setDateCommit(localXmlPullParser.nextText());
              localObject2 = localObject1;
              localObject3 = paramInputStream;
            }
            else
            {
              localObject2 = localObject1;
              localObject3 = paramInputStream;
              if (str.equals("link"))
              {
                paramInputStream.setLink(localXmlPullParser.nextText());
                localObject2 = localObject1;
                localObject3 = paramInputStream;
                continue;
                localObject2 = localObject1;
                localObject3 = paramInputStream;
                if (localXmlPullParser.getName().equalsIgnoreCase("item"))
                {
                  localObject2 = localObject1;
                  localObject3 = paramInputStream;
                  if (paramInputStream != null)
                  {
                    ((ArrayList)localObject1).add(paramInputStream);
                    localObject2 = localObject1;
                    localObject3 = paramInputStream;
                  }
                }
              }
            }
          }
        }
      }
    }
    return (ArrayList<Commit>)localObject1;
  }
  
  private String readAllLines(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  private ArrayList<Depot> readDepotsJSON(InputStream paramInputStream)
    throws IOException, JSONException
  {
    paramInputStream = new JSONObject(readAllLines(paramInputStream));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramInputStream.keys();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localArrayList.add(new Depot(paramInputStream.getJSONObject(String.valueOf(localObject)).getString("name"), paramInputStream.getJSONObject(String.valueOf(localObject)).getString("description"), paramInputStream.getJSONObject(String.valueOf(localObject)).getJSONArray("owners").getString(0), paramInputStream.getJSONObject(String.valueOf(localObject)).getString("lastChange"), paramInputStream.getJSONObject(String.valueOf(localObject)).getString("accessRestriction")));
    }
    return localArrayList;
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    boolean bool1 = false;
    final Object localObject6 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    GitblitWatchDAOSQLite localGitblitWatchDAOSQLite = GitblitWatchDAOSQLite.getInstance(this);
    Object localObject5 = null;
    HttpsURLConnection localHttpsURLConnection = null;
    Object localObject1 = localHttpsURLConnection;
    paramIntent = (Intent)localObject5;
    Object localObject4;
    do
    {
      try
      {
        this.sslContext = createSSLContext("lps3im", 2131165184);
        localObject1 = localHttpsURLConnection;
        paramIntent = (Intent)localObject5;
        Object localObject7 = new URL(((SharedPreferences)localObject6).getString("Serveur", "") + "/gitblit/rpc/?req=LIST_REPOSITORIES");
        localObject1 = localHttpsURLConnection;
        paramIntent = (Intent)localObject5;
        Authenticator.setDefault(new Authenticator()
        {
          protected PasswordAuthentication getPasswordAuthentication()
          {
            return new PasswordAuthentication(localObject6.getString("Identifiant", "bocah002"), localObject6.getString("Password", "").toCharArray());
          }
        });
        localObject1 = localHttpsURLConnection;
        paramIntent = (Intent)localObject5;
        localHttpsURLConnection = (HttpsURLConnection)((URL)localObject7).openConnection();
        localObject1 = localHttpsURLConnection;
        paramIntent = localHttpsURLConnection;
        localHttpsURLConnection.setSSLSocketFactory(this.sslContext.getSocketFactory());
        localObject1 = localHttpsURLConnection;
        paramIntent = localHttpsURLConnection;
        localObject5 = readDepotsJSON(localHttpsURLConnection.getInputStream()).iterator();
        for (;;)
        {
          localObject1 = localHttpsURLConnection;
          paramIntent = localHttpsURLConnection;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject1 = localHttpsURLConnection;
          paramIntent = localHttpsURLConnection;
          localObject7 = (Depot)((Iterator)localObject5).next();
          if (!bool1)
          {
            localObject1 = localHttpsURLConnection;
            paramIntent = localHttpsURLConnection;
            bool1 = localGitblitWatchDAOSQLite.depotCompare((Depot)localObject7);
          }
          else
          {
            localObject1 = localHttpsURLConnection;
            paramIntent = localHttpsURLConnection;
            localGitblitWatchDAOSQLite.depotCompare((Depot)localObject7);
          }
        }
        Depot localDepot;
        Iterator localIterator;
        boolean bool2;
        localObject3 = localObject4;
      }
      catch (Exception localException)
      {
        paramIntent = (Intent)localObject1;
        localException.printStackTrace();
        if (localObject1 != null) {
          ((HttpsURLConnection)localObject1).disconnect();
        }
        return;
        localObject1 = localException;
        paramIntent = localException;
        localObject7 = localGitblitWatchDAOSQLite.getAllDepots().iterator();
        localObject1 = localException;
        paramIntent = localException;
        if (((Iterator)localObject7).hasNext())
        {
          localObject1 = localException;
          paramIntent = localException;
          localDepot = (Depot)((Iterator)localObject7).next();
          localObject1 = localException;
          paramIntent = localException;
          localObject5 = (HttpsURLConnection)new URL(((SharedPreferences)localObject6).getString("Serveur", "") + "/gitblit/feed/~" + localDepot.getCreator() + "/" + localDepot.getNom()).openConnection();
          localObject1 = localObject5;
          paramIntent = (Intent)localObject5;
          ((HttpsURLConnection)localObject5).setSSLSocketFactory(this.sslContext.getSocketFactory());
          localObject1 = localObject5;
          paramIntent = (Intent)localObject5;
          localIterator = parseCommitsXml(((HttpsURLConnection)localObject5).getInputStream()).iterator();
          bool2 = bool1;
          for (;;)
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            bool1 = bool2;
            paramIntent = (Intent)localObject5;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = localObject5;
            paramIntent = (Intent)localObject5;
            localObject4 = (Commit)localIterator.next();
            if (!bool2)
            {
              localObject1 = localObject5;
              paramIntent = (Intent)localObject5;
              bool2 = localGitblitWatchDAOSQLite.commitCompare((Commit)localObject4, localDepot);
            }
            else
            {
              localObject1 = localObject5;
              paramIntent = (Intent)localObject5;
              localGitblitWatchDAOSQLite.commitCompare((Commit)localObject4, localDepot);
            }
          }
        }
      }
      finally
      {
        if (paramIntent != null) {
          paramIntent.disconnect();
        }
      }
      paramIntent = (Intent)localObject4;
      localObject5 = new Intent("done_depot");
      Object localObject3 = localObject4;
      paramIntent = (Intent)localObject4;
      LocalBroadcastManager.getInstance(this).sendBroadcast((Intent)localObject5);
      localObject3 = localObject4;
      paramIntent = (Intent)localObject4;
      localObject5 = new android.support.v7.app.NotificationCompat.Builder(this);
      localObject3 = localObject4;
      paramIntent = (Intent)localObject4;
      if ((((SharedPreferences)localObject6).getBoolean("Notifications", false)) && (bool1))
      {
        localObject3 = localObject4;
        paramIntent = (Intent)localObject4;
        localObject6 = PendingIntent.getActivity(this, 0, new Intent(this, DepotActivity.class), 0);
        localObject3 = localObject4;
        paramIntent = (Intent)localObject4;
        ((android.support.v7.app.NotificationCompat.Builder)localObject5).setSmallIcon(2130903041).setContentTitle(getResources().getString(2131230740)).setContentText("Nouveau commit/dépot !").setContentIntent((PendingIntent)localObject6).setAutoCancel(true);
        localObject3 = localObject4;
        paramIntent = (Intent)localObject4;
        localObject5 = ((android.support.v7.app.NotificationCompat.Builder)localObject5).build();
        localObject3 = localObject4;
        paramIntent = (Intent)localObject4;
        ((NotificationManager)getSystemService("notification")).notify(0, (Notification)localObject5);
      }
    } while (localObject4 == null);
    ((HttpsURLConnection)localObject4).disconnect();
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\DepotService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */