package model;

public class Loja {

	// CONTRUCT PARA CADASTRAR!
	public Loja(String marca, String modelo, String cor, double km, double valor) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.km = km;
		this.valor = valor;
	}

	// CONSTRUCT PARA ALTERAR OS DADOS!!
	public Loja(int id, String marca, String modelo, String cor, double km, double valor) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.km = km;
		this.valor = valor;
	}

	// CONSTRUCT PARA MOSTRAR TODOS!!!
	public Loja() {}

	private int id;
	private String marca;
	private String modelo;
	private String cor;
	private double km;
	private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
