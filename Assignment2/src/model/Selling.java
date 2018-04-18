package model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("model.Selling")
public class Selling {
	@XStreamAlias("nume_med")
	private String nume_med;
	@XStreamAlias("bani_client")
	private int bani_client;
	@XStreamAlias("total_quantity")
private int total_quantity;
	@XStreamAlias("nume_client")
private String nume_client;
public Selling( String nume_m,int  t_q,  String n_c,int ba)
{
	this.nume_client=n_c;
	this.nume_med=nume_m;
	this.total_quantity=t_q;
	this.bani_client=ba;
}
public int getTotalQuantity()
{
	return this.total_quantity;
}
public int getBani()
{
	return this.bani_client;
}

public void setTotalQuantity(int id)
{
	this.total_quantity=id;
}

public void setBani(int id)
{
	this.bani_client=id;
}
public void setClient(String s)
{
	this.nume_client=s;
}
public String getClient() {
	return this.nume_client;
}
public void setMedic(String s)
{
	this.nume_med=s;
}
public String getMedic() {
	return this.nume_med;
}
}
