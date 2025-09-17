package Main_Package;

class ship{
	private String name;
	private String captain;
	
	public ship(String name, String captain) {
		this.name = name;
		this.captain = captain;
	}
	
	@Override
	public String toString() {
		return name + "| Capt. " + captain;
	}
}