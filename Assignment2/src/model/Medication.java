package model;
 

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("model.Medication")
public class Medication {
@XStreamAlias("name")
private String name;
@XStreamAlias("ingredients")
private String ingredients;
@XStreamAlias("manufacter")
private String manufacter;
@XStreamAlias("quantity")
private int quantity;
@XStreamAlias("price")
private int price; 

public Medication(String name, String in,String m,int q, int p )
{
	this.name=name;
	this.ingredients=in;
	this.manufacter=m;
	this.quantity=q;
	this.price=p; 
}
public String getName()
{
	return this.name;
	
}
public int getQuantity()
{
	return this.quantity;
}
public int getPrice()
{
	return this.price;
} 
public String getManufacter()
{
	return this.manufacter;
}
public String getIngredients()
{
	return this.ingredients;
}
public void setName(String n)
{
	this.name=n;
}
public void setQuantity(int i)
{
	this.quantity=i;
}
public void setPrice(int i)
{
	this.price=i;
}
public void setManufacter(String n)
{
	this.manufacter=n;
}
public void setIngredients(String in)
{
	this.ingredients=in;
}
}
