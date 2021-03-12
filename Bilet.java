package tema1;

public class Bilet extends Beneficiu{
	/**
	 * vector ce retine valoare p/b/e ce reprezinta tipul biletului
	 * pentru fiecare persoana din Pasager (grup/familie/singur)
	 */
	private
		String [] tip_bilet;
	
	/**
	 * constructor fara parametru pentru Clasa Bilet
	 * ce initializeaza vectorul tip_bilet
	 */
	Bilet()
	{
		super.setID("");
		tip_bilet = new String[0];
	}
	
	/**
	 * Constructo pentru Clasa Bilet cu parametrul id, ce
	 * seteaza acest Camp din clasa Pasager
	 * 
	 * @param id
	 */
	Bilet(String id) {
		super.setID(id);
		this.tip_bilet = new String[0];
	}
	
	/**
	 * metoda addinfo adauga informatia primita ca parametru in campul tip_bilet clasei Bilet si 
	 * apeleaza din clasa superioara Beneficiu metoda add_info ce adauga informatia despre 
	 * imbarcare_prioritara si nevoi_speciale iar aceasta metoda apeleaza din clasa superioara, 
	 * Pasager, metoda add_Info ce adauga informatia despre nume si varsta in campurile din clasa mentionata. 
	 * Vectorul tip_bilet este realocat de fiecare data cand o nou persoana 
	 * este adugata intr-o familie sau grup
	 * 
	 * @param nume
	 * @param varsta
	 * @param tip_bilet
	 * @param imbarcare_prioritara
	 * @param nevoi_speciale
	 */
	public void addinfo(String nume, int varsta, String tip_bilet, boolean imbarcare_prioritara, boolean nevoi_speciale) {
		String [] aux = new String[super.get_n()];
		int i;
		
		for(i = 0; i < super.get_n(); i++) {
			aux[i] = this.tip_bilet[i];
		}
		
		this.tip_bilet = new String[super.get_n() + 1];
		
		for(i = 0; i < super.get_n(); i++) {
			this.tip_bilet[i] = aux[i];
		}
		this.tip_bilet[super.get_n()] = tip_bilet;
		
		super.add_info(nume, varsta, imbarcare_prioritara, nevoi_speciale);
	}
	
	/**
	 * metoda calculeaza prioriatea Pasagerilor dupa regulile date si 
	 * intoarce valoare finala
	 * 
	 * @return priority
	 */
	public int get_priority() {
		int i = 0, priority = 0;
		
		if(super.get_ID().substring(0, 1).equals("f")) {
			priority += 10;
		}
		if(super.get_ID().substring(0, 1).equals("g")) {
			priority += 5;
		}		
		
		do{
			if(super.get_varsta(i) < 2) {
				priority += 20;
			} 
			if(super.get_varsta(i) >= 2 && super.get_varsta(i) < 5) {
				priority += 10;
			}	
			if(super.get_varsta(i) >= 5 && super.get_varsta(i) < 10) {
				priority += 5;
			}	
			if(super.get_varsta(i) >= 60) {
				priority += 15;
			}	
			if(super.get_imbarcare_prioritara(i)) {
				priority += 30;
			}
			if(super.get_nevoi_speciale(i)) {
				priority += 100;
			}
			if(this.tip_bilet[i].equals("b")) {
				priority += 35;
			}
			if(this.tip_bilet[i].equals("p")) {
				priority += 20;
			}
			i++;
		}while(i < super.get_n());
		
		return priority;
	}
	/**
	 * metoda get_id intoarce id - ul Pasagerului, iar pentru a accesa acest camp
	 * este apelata metodata din clasa pe careo mosteneste, Beneficiu.
	 * 
	 * @return id id -- ul Pasagerului
	 */
	public String get_id() {
		return super.get_ID();
	}
	/**
	 * metoda seteaza sau actualizeaza prioritatea Pasagerului, campul din clasa
	 * Pasager
	 * 
	 */
	public void set_priority() {
		super.setPriority(get_priority());
	}
}
