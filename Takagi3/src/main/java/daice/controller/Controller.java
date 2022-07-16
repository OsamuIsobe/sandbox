package daice.controller;

import java.io.IOException;

import daice.constants.Constants;
import daice.constants.Constants.Message;
import daice.serviceImpl.Repeat;

public class Controller{
	public static void main(String[] args)throws IOException {
		Repeat.repeatBattle();
		Message.MESSAGE_LINE01.showMessage();
		Message.MESSAGE02.showMessage();
	}
}