package br.com.cidadedepapel.pedido.models;

public enum Uf {
	SP(new Long(0)),
	AC(new Long(1)),
	AL(new Long(2)),
	AP(new Long(3)),
	AM(new Long(4)),
	BA(new Long(5)),
	CE(new Long(6)),
	DF(new Long(7)),
	ES(new Long(8)),
	GO(new Long(9)),
	MA(new Long(10)),
	MT(new Long(11)),
	MS(new Long(12)),
	MG(new Long(13)),
	PA(new Long(14)),
	PB(new Long(15)),
	PR(new Long(16)),
	PE(new Long(17)),
	PI(new Long(18)),
	RJ(new Long(19)),
	RN(new Long(20)),
	RS(new Long(21)),
	RO(new Long(22)),
	RR(new Long(23)),
	SC(new Long(24)),
	SE(new Long(25)),
	TO(new Long(26));
	;

	    private Long id;

	    Uf(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }
	
	
	public static Uf getById(Long id) {
	    for(Uf e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return null;
	}
	
	
}

