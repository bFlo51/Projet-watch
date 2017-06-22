package com.example.dark.gitblitandroid.model;

import java.io.Serializable;

public class Depot
  implements Serializable, Comparable<Depot>
{
  private String access;
  private String creator;
  private String description;
  private int id;
  private String lastChange;
  private String nom;
  
  public Depot(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.nom = paramString1;
    this.description = paramString2;
    this.creator = paramString3;
    this.lastChange = paramString4;
    this.access = paramString5;
    this.id = paramInt;
  }
  
  public Depot(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.nom = paramString1;
    this.description = paramString2;
    this.creator = paramString3;
    this.lastChange = paramString4;
    this.access = paramString5;
  }
  
  public int compareTo(Depot paramDepot)
  {
    return this.nom.compareToIgnoreCase(paramDepot.getNom());
  }
  
  public String getAccess()
  {
    return this.access;
  }
  
  public String getCreator()
  {
    return this.creator;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getLastChange()
  {
    return this.lastChange;
  }
  
  public String getNom()
  {
    return this.nom.substring(this.nom.lastIndexOf("/") + 1);
  }
  
  public void setAccess(String paramString)
  {
    this.access = paramString;
  }
  
  public void setCreator(String paramString)
  {
    this.creator = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLastChange(String paramString)
  {
    this.lastChange = paramString;
  }
  
  public void setNom(String paramString)
  {
    this.nom = paramString;
  }
  
  public String toString()
  {
    String str = new String();
    str = str + "Nom dépot : " + this.nom;
    str = str + "Description dépot : " + this.description;
    str = str + "Créateur : " + this.creator;
    str = str + "Dernier changement : " + this.lastChange;
    return str + "Accès : " + this.access;
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\model\Depot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */