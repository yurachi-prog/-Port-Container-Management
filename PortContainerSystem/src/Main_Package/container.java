package Main_Package;

class container {
	private String id;
	private String description;
	private int weight;
	
		public container(String id, String description, int weight) {
			this.id = id;
			this.description = description;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return id + "|" + description + "|" + weight + "kg";
		}
}