package model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("model.Administrator")
public class Administrator  {
	@XStreamAlias("id")
	private int id;
	@XStreamAlias("nume")
	private String nume;
	@XStreamAlias("password")
	private String password;
	
public Administrator()
{
	
}
public Administrator(int id)
{
	this.id=id;
}
public Administrator( int id, String nume, String password)
{
	this.id=id;
	this.nume=nume;
	this.password= password;
}
public Administrator( String nume, String pass)
{
	this.nume=nume;
	this.password=pass;
}
public String getNume()
{
	return this.nume ;
}
public int getId()
{
	return this.id;
}

public String getPassword()
{
	return this.password ;
}
public void setId(int id)
{
	this.id=id;
}
public void setNume(String nume)
{
	this.nume=nume;
}
public void setPassword(String password)
{
	this.password=password;
}


}
