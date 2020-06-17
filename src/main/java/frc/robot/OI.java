package frc.robot;

import harkerrobolib.wrappers.XboxGamepad;

/**
 * Takes in input from the controller
 * 
 * @author Aimee Wang
 * @since June 16, 2020
 */
public class OI {
    private static OI instance;

    private XboxGamepad driverGamepad;
    private XboxGamepad operatorGamepad;

    public static final double JOYSTICK_DEADBAND = 0;

    private OI() {

        driverGamepad = new XboxGamepad(RobotMap.DRIVER_PORT);
        operatorGamepad = new XboxGamepad(RobotMap.OPERATOR_PORT);

        initBindings();
    }

    private void initBindings() {
        
    }

    public XboxGamepad getDriverGamepad() {
        return driverGamepad;
    }

    public XboxGamepad getOperatorGamepad() {
        return operatorGamepad;
    }

    public static OI getInstance() {
        if(instance == null)
            instance = new OI();

        return instance;
    }
}