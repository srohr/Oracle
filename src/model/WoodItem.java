/**
 * Class defining the elements of a wood type
 */
package model;

/**
 * @author USER
 *
 */
public class WoodItem {

	String type;
	Double baseDeliveryTime;
	Double price;
	
	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Bare Foot
	 */
	public WoodItem(String type, Double daseDeliveryTime, Double price) {
		this.type = type;
		this.baseDeliveryTime = daseDeliveryTime;
		this.price = price;
	}

    public WoodItem(String type) {
        this.type = type;
        this.baseDeliveryTime = 0.0;
        this.price = 0.0;
    }

	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public Double getDaseDeliveryTime() {
        if (type.equals("Cherry"))                   baseDeliveryTime = 2.5;
        else if (type.equals("Curly Maple"))         baseDeliveryTime = 1.5;
        else if (type.equals("Genuine Mahogany"))    baseDeliveryTime = 3.0;
        else if (type.equals("Wenge"))               baseDeliveryTime = 5.0;
        else if (type.equals("White Oak"))           baseDeliveryTime = 2.3;
        else if (type.equals("Sawdust"))             baseDeliveryTime = 1.0;

        return baseDeliveryTime;
	}

    public Double GetDeliveryTime(int count){
        Double dtime = 0.0;

        double modif = (Integer)((count - 1)/100) + 1;
        if (modif == 6.0)
            modif = 5.5;

        dtime = modif * baseDeliveryTime;

        return dtime;
    }

	/**
	 * 
	 * Get the price per Bare Foot
	 * 
	 * @return the price for 1 Bare Foot of this WoodItem
	 */
	public Double getPricePerUnit() {
        if (type.equals("Cherry"))                   price = 5.95;
        else if (type.equals("Curly Maple"))         price = 6.00;
        else if (type.equals("Genuine Mahogany"))    price = 9.60;
        else if (type.equals("Wenge"))               price = 22.35;
        else if (type.equals("White Oak"))           price = 6.70;
        else if (type.equals("Sawdust"))             price = 1.50;

		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	/*@Override
	public String toString() {	
		return "";
	}*/
	
}
