package com.example.dark.gitblitandroid.model;

public class Commit
{
  private String dateCommit;
  private String description;
  private String developper;
  private String link;
  
  public Commit()
  {
    this.description = "...";
    this.dateCommit = "...";
    this.developper = "...";
    this.link = "...";
  }
  
  public Commit(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.description = paramString1;
    this.dateCommit = paramString2;
    this.developper = paramString3;
    this.link = paramString4;
  }
  
  public String getDateCommit()
  {
    return this.dateCommit;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getDevelopper()
  {
    return this.developper;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public void setDateCommit(String paramString)
  {
    this.dateCommit = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setDevelopper(String paramString)
  {
    this.developper = paramString;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public String toString()
  {
    return "Desc : " + this.description + " DateCommit : " + this.dateCommit + " Développeur : " + this.developper;
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\model\Commit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */