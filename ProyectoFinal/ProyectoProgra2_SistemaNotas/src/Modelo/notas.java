package Modelo;

public class notas {

	public double nota;
	public int inscrito_id_inscrito;
    public int NotasPonderacion_id_ponderacion;
    
    public notas(double nota, int inscrito_id_inscrito, int NotasPonderacion_id_ponderacion) {
    	this.nota = nota;
    	this.inscrito_id_inscrito = inscrito_id_inscrito;
    	this.NotasPonderacion_id_ponderacion = NotasPonderacion_id_ponderacion;
    	
    }

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getInscrito_id_inscrito() {
		return inscrito_id_inscrito;
	}

	public void setInscrito_id_inscrito(int inscrito_id_inscrito) {
		this.inscrito_id_inscrito = inscrito_id_inscrito;
	}

	public int getNotasPonderacion_id_ponderacion() {
		return NotasPonderacion_id_ponderacion;
	}

	public void setNotasPonderacion_id_ponderacion(int notasPonderacion_id_ponderacion) {
		NotasPonderacion_id_ponderacion = notasPonderacion_id_ponderacion;
	}
}
