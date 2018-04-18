package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("model.Employee")
public class Employee  {
	@XStreamAlias("idemployee")
	private int idemployee;
	@XStreamAlias("nume")
	private String nume;
	@XStreamAlias("password")
	private String password;
	@XStreamAlias("adresa")
	private String adresa;
public Employee()
{
	
}
public Employee( String nume,  String ad)
{ 
	this.nume=nume; 
	this.adresa= ad;
}
public int getId()
{
	return this.idemployee;
}
public void setId(int id)
{
this.idemployee=id;	
}
public String getNume()
{
	return this.nume ;
}
public String getAdresa()
{
	return this.adresa;
}
public String getPassword()
{
	return this.password ;
}
public void setNume(String nume)
{
	this.nume=nume;
}
public void setPassword(String password)
{
	this.password=password;
}
public void setAdresa(String adresa)
{
	this.adresa=adresa;
}
}
