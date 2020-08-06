package dao;

public class DAOException extends Exception {
	public DAOException(String mensagem) {
		super(mensagem);
	}
	public String toString() {
		return "Erro no DAO: "+this.getMessage();
	}
}