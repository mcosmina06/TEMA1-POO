package tema1;

public abstract class Pasager {
	/**
	 * se retine id - ul Pasagerului
	 */
	private String id;
	/**
	 * vector ce retine numele pasagerilor din familie/grup/singur
	 */
	private	String [] nume;
	/**
	 * vector ce retine varstele pasagerilor din familie/grup/singur
	 */
	private	int [] varsta;
	/**
	 * variabila ce retine prioritatea Pasagerului
	 */
	private int priority;
	/**
	 * variabila ce retine numarul curent de persoane din pasager; 1 in 
	 * cazul persoanelor sigure
	 */
	private	int n;
		
	/**
	 * Constructor fara parametru ce initializeaza vectorii si variabilele 
	 * din clasa curenta
	 */
	Pasager() {
		id = "";
		nume = new String[0];
		varsta = new int[0];
		priority = 0;
		n = 0;
	}
	
	/**
	 * metoda primeste ca parametru numele id - ului Pasagerului
	 * si il seteaza
	 * 
	 * @param id noua valoare a id - ului
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * metoda primeste ca parametru valoarea prioritatii calculata in clasa
	 * Bilet si actualizeaza campul din clasa curenta
	 * 
	 * @param priority noua valoare a prioritatii
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * metoda intoarce id -ul Pasagerului
	 * 
	 * @return id id - ul Pasagerului
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * metoda primeste ca parametru pozitia de pe care se doreste informatia
	 * din vectorul de varste
	 * 
	 * @param x pozitia de pe care se doreste varsta
	 * @return varsta valoarea varstei
	 */
	public int getVarsta(int x) {
		return this.varsta[x];
	}
	
	/**
	 * metoda intoarce numarul curent de persoane din familie sau grup, adica 
	 * din Pasager
	 * 
	 * @return n numarul de persoane
	 */
	public int get_n() {
		return this.n;
	}

	/**
	 * metoda intoarce prioritatea Pasagerului
	 * 
	 * @return priority prioritatea grupului
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * metoda addInfo adauga informatia despre nume si varsta in campurile 
	 * din clasa curenta, vectorii de nume si varsta fiind realocati
	 * 
	 * @param nume noul nume de adaugat
	 * @param varsta noua varsta de adaugat
	 */
	public void addInfo(String nume, int varsta) {
		String [] aux_n = new String[n];
		int [] aux_v = new int[n];
		int i;
		
		for(i = 0; i < n; i++) {
			aux_n[i] = this.nume[i];
			aux_v[i] = this.varsta[i];	
		}
		
		this.n++;
		this.nume = new String[this.n];
		this.varsta = new int[this.n];	
			
		for(i = 0; i < n - 1; i++) {
			this.nume[i] = aux_n[i];	
			this.varsta[i] = aux_v[i];	
		}
		
		this.nume[this.n - 1] = nume;	
		this.varsta[this.n - 1] = varsta;
	}
	
	/**
	 * metoda ce trebuie implementata in clasa beneficiu
	 * 
	 * @param x noul nume de adaugat
	 * @param y noua varsta de adaugat
	 * @param z valoarea imbarcarii prioritarea
	 * @param w valoarea nevoii speciale
	 */
	public abstract void add_info(String x, int y, boolean z, boolean w);
	
}
