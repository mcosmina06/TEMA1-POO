package tema1;

public class Beneficiu extends Pasager{
	/**
	 * vector ce retine valoare true/ false a imbarcarii prioritare
	 * pentru fiecare persoana din Pasager (grup/familie/singur)
	 */
	private	boolean [] imbarcare_prioritara;
	/**
	 * vector ce retine valoare true/ false a nevoii speciale
	 * pentru fiecare persoana din Pasager (grup/familie/singur)
	 */
	private	boolean [] nevoi_speciale;

	/**
	 * constructor fara parametru pentru Clasa Beneficiu
	 * ce initializeaza cei doi vectori
	 */
	public Beneficiu() {
		imbarcare_prioritara = new boolean[0];
		nevoi_speciale = new boolean[0];
	}
	
	/**
	 * metoda add_info adauga informatia primita ca parametru in campurile imbarcare_prioritara
	 * si nevoi_speciale ale clasei Beneficiu si apeleaza din clasa superioara metoda addInfo ce 
	 * adauga informatia despre nume si varsta in campurile din clasa de baza Pasager. Vectorii 
	 * imbarcare_prioritara si nevoi_speciale sunt realocati de fiecare data cand o nou persoana 
	 * este adugata intr-o familie sau grup
	 * 
	 * @param nume numele de adaugat
	 * @param varsta varsta de adaugat
	 * @param imbarcare_prioritara valoarea imbarcarii prioritare
	 * @param nevoi_speciale valoarea nevoii speciale
	 */
	public void add_info(String nume, int varsta, boolean imbarcare_prioritara, boolean nevoi_speciale) {
		boolean [] aux1 = new boolean[super.get_n()];
		boolean [] aux2 = new boolean[super.get_n()];
		int i;
		for(i = 0; i < super.get_n(); i++)
		{
			aux1[i] = this.imbarcare_prioritara[i];
			aux2[i] = this.nevoi_speciale[i];
		}
		
		this.imbarcare_prioritara = new boolean[super.get_n() + 1];
		this.nevoi_speciale = new boolean[super.get_n() + 1];		

		for(i = 0; i < super.get_n(); i++)
		{
			this.imbarcare_prioritara[i] = aux1[i];
			this.nevoi_speciale[i] = aux2[i];
		}	

		this.imbarcare_prioritara[super.get_n()] = imbarcare_prioritara;
		this.nevoi_speciale[super.get_n()] = nevoi_speciale;
		super.addInfo(nume, varsta);
	}
	
	/**
	 * metoda primeste ca parametru un intreg x ce reprezinta pozitia, din 
	 * vectorul varsta din clasa de baza, de pe care se doreste informatia
	 * 
	 * @param x pozitia de pe care se doreste valoarea varstei
	 * @return varsta valoarea varstei
	 */
	public int get_varsta(int x)
	{
		return super.getVarsta(x);
	}

	/**
	 * metoda intoarce id - ul Pasagerului ce se afla in clasa de baza Pasager
	 * 
	 * @return id id - ul Pasagerului
	 */
	public String get_ID()
	{
		return super.getID();
	}
	
	/**
	 * metoda primeste ca parametru un intreg x ce reprezinta pozitia, din 
	 * vectorul imbarcare_prioritara din curenta, de pe care se doreste informatia 
	 *  
	 * @param x pozitia de pe care se doreste valoarea imbarcarii prioritare
	 * @return imbarcare_prioritara valoarea imbarcarii prioritare
	 */
	public boolean get_imbarcare_prioritara(int x)
	{
		return imbarcare_prioritara[x];
	}
	
	/**
	 * metoda primeste ca parametru un intreg x ce reprezinta pozitia, din 
	 * vectorul nevoi_speciale din curenta, de pe care se doreste informatia 
	 * 
	 * @param x ozitia de pe care se doreste valoarea nevoii speciale
	 * @return nevoi_speciale valoarea nevoii speciale
	 */
	public boolean get_nevoi_speciale(int x)
	{
		return nevoi_speciale[x];
	}
	
}
