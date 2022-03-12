
public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Title: "+this.title+"Author: "+this.author+"Description: "+this.description+"Material: "+this.material);
	}

}
