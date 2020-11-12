package entity;

public class Door {
	private DoorState state;
	
	public Door(DoorState state) {
		this.state = state;
	}
	public Door() {
		state = DoorState.open;
	}
	public void setDoorState(DoorState state) {
		this.state = state;
	}
	public DoorState getDoorState() {
		return this.state;
	}
	public void changeDoorState() {
		if(state == DoorState.Close)
			state = DoorState.open;
		else if(state == DoorState.open)
			state = DoorState.Close;
	}
}
