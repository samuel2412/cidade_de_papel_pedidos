package br.com.cidadedepapel.pedido.models;

public enum ContatoTipo {
	CELULAR(new Long(0)),
	FIXO(new Long(1)),
	EMAIL(new Long(2)),
	FAX(new Long(3));

	    private Long id;

	    ContatoTipo(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }
	
	
	public static ContatoTipo getById(Long id) {
	    for(ContatoTipo e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return null;
	}
}
