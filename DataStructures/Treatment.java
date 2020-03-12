abstract class Treatment implements HealAbility{
	private int heal;
	Treatment(int heal){
		this.heal = heal;
	}
	public String toString(){
		return "Treatment with "+this.heal+" heal";
	}
}