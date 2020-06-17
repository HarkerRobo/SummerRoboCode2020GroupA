package frc.robot.subsystems;

import harkerrobolib.subsystems.HSSwerveDrivetrain;
import harkerrobolib.util.SwerveModule;
import harkerrobolib.wrappers.HSPigeon;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

/**
 * Manages the swerve drivetrain.
 * 
 * @author Arjun Dixit
 * @since  June 16, 2020
 */
public class Drivetrain extends HSSwerveDrivetrain {

    private static Drivetrain instance;

    public static final int DRIVE_VELOCITY_SLOT = 0;
    public static final int ANGLE_POSITION_SLOT = 0;
    public static final double MAX_DRIVE_VELOCITY = 0;
    public static final double MAX_ROTATION_VELOCITY = 0;
    public static final double PIGEON_kP = 0;

    private static final int[] offsets = {9084, 5951, 1582, 5891};
    private static TalonFXInvertType[] driveInverts = {TalonFXInvertType.Clockwise, TalonFXInvertType.Clockwise, TalonFXInvertType.Clockwise, TalonFXInvertType.Clockwise};
    private static boolean[] angleInverts = {true, true, true, false};
    private static boolean[] driveSensorPhases = {true, true, false, false};
    private static boolean[] angleSensorPhases = {true, true, true, false};
    private static final double DT_WIDTH = 0.535; //meters
    private static final double DT_LENGTH = 0.645; //meters
    private static final double WHEEL_DIAMETER = 4; //inches
    private static final double GEAR_RATIO = 6;


    private Drivetrain() {
        super(initSwerveModules(), new HSPigeon(RobotMap.CAN_IDS.PIGEON_ID), DT_WIDTH, DT_LENGTH);

    }

    private static SwerveModule[] initSwerveModules() {
        SwerveModule[] modules = new SwerveModule[offsets.length];

        for(int i = 0; i < offsets.length; i++) {
            modules[i] = new SwerveModule(
                                RobotMap.CAN_IDS.DRIVE_IDS[i], driveInverts[i], driveSensorPhases[i], 
                                RobotMap.CAN_IDS.ANGLE_IDS[i], angleInverts[i], 
                                angleSensorPhases[i], WHEEL_DIAMETER, GEAR_RATIO, offsets[i]);
        }
        return modules;
    }

    public static Drivetrain getInstance() {
        if(instance == null)
            instance = new Drivetrain();
        return instance;
    }

}