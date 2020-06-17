package frc.robot.commands.drivetrain;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.util.MathUtil;

public class SwerveManual extends harkerrobolib.commands.drivetrain.SwerveManual {

    private static final boolean IS_PERCENT_OUTPUT = false;

    private static final double OUTPUT_MULTIPLIER = 1;

    private double translateX;
    private double translateY;
    private double turnMagnitude;

    private static boolean pigeonFlag;
    private static double prevPigeonHeading;
    private static boolean joystickFlag;
    
    public SwerveManual() {

        super(Drivetrain.getInstance(), Drivetrain.DRIVE_VELOCITY_SLOT, Drivetrain.ANGLE_POSITION_SLOT, OI.getInstance().getDriverGamepad(), Drivetrain.MAX_DRIVE_VELOCITY, Drivetrain.MAX_ROTATION_VELOCITY, Drivetrain.PIGEON_kP, OUTPUT_MULTIPLIER);
        pigeonFlag = false;

    }

    @Override
    public void initialize() {

        pigeonFlag = true;

        joystickFlag = true;
    }

    @Override
    public void execute() {

        translateX = MathUtil.mapJoystickOutput(OI.getInstance().getDriverGamepad().getLeftX(), OI.JOYSTICK_DEADBAND);
        translateY = MathUtil.mapJoystickOutput(OI.getInstance().getDriverGamepad().getLeftY(), OI.JOYSTICK_DEADBAND);
        turnMagnitude = MathUtil.mapJoystickOutput(OI.getInstance().getDriverGamepad().getRightX(), OI.JOYSTICK_DEADBAND);

        translateX *= OUTPUT_MULTIPLIER * Drivetrain.MAX_DRIVE_VELOCITY;
        translateY *= OUTPUT_MULTIPLIER * Drivetrain.MAX_DRIVE_VELOCITY;
        turnMagnitude *= OUTPUT_MULTIPLIER * Drivetrain.MAX_ROTATION_VELOCITY;

    }

    @Override
    public void end(boolean interrupted) {
        
    }
}