package daice.controller;

import java.io.IOException;

import daice.constants.Constants;
import daice.serviceImpl.Repeat;

public class Controller{
	public static void main(String[] args)throws IOException {
		Repeat.repeatBattle();
		Constants.Message.MESSAGE_LINE01.showMessage();
		Constants.Message.MESSAGE02.showMessage();
	}
}