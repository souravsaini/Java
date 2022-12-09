package abstractclass;

public class LList implements NodeList {
	private ListItem root = null;

	public LList(ListItem root) {
		super();
		this.root = root;
	}

	@Override
	public ListItem getRoot() {
		return this.root;
	}

	@Override
	public boolean addItem(ListItem item) {
		if(this.root == null) {
			this.root = item;
			return true;
		}
		
		ListItem currentItem = this.root;
		while(currentItem != null) {
			int compare = currentItem.compareTo(item);
			if(compare < 0) {
				if(currentItem.next() != null) {
					currentItem = currentItem.next();
				} else {
					currentItem.setNext(item);
					item.setPrevious(currentItem);
					return true;
				}
			} else if(compare > 0) {
				if(currentItem.previous() != null) {
					currentItem.previous().setNext(item);
					item.setPrevious(currentItem.previous());
					item.setNext(currentItem);
					currentItem.setPrevious(item);
				} else {
					item.setNext(this.root);
					this.root.setPrevious(item);
					this.root = item;
				}
				return true;
			} else {
				System.out.println(item.getValue() + " is already present");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeItem(ListItem item) {
		ListItem currentItem = this.root;
		while(currentItem != null) {
			int compare = currentItem.compareTo(item);
			if(compare == 0) {
				if(currentItem == this.root) {
					this.root = currentItem.next();
				} else {
					currentItem.previous().setNext(currentItem.next());
					if(currentItem.next() != null) {
						currentItem.next().setPrevious(currentItem.previous());
					}
				}
				return true;
			} else if(compare < 0) {
				currentItem = currentItem.next();
			} else {
				System.out.println("Item not found");
				return false;
			}
		}
		return false;
	}

	@Override
	public void traverse(ListItem root) {
		if(root == null) return;
		
		while(root != null) {
			System.out.println(root.getValue());
			root = root.next();
		}
	}
	
	
}
