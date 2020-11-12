package controlLogic;

import control.DoorControl;
import entity.Door;
import entity.DoorState;

public class DoorControlLogic implements DoorControl{
	private Door door;
	
	public DoorControlLogic() {
		this.door = new Door();
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		if(this.isOpen()) {
			System.out.println("Open");
			return;
		} else {
			System.out.println("Can't Open, Door is lock");
			return;
		}
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		DoorState state = door.getDoorState();
		if(state == DoorState.open)
			return true;
		return false;
	}
	@Override
	public void change() {
		// TODO Auto-generated method stub
		if(door.getDoorState() == DoorState.open)
			door.setDoorState(DoorState.Close);
		else if(door.getDoorState() == DoorState.Close)
			door.setDoorState(DoorState.open);
		System.out.printf("Success, Now State : %s\n",door.getDoorState());
	}

}
