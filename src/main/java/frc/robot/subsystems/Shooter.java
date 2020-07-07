package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

import harkerrobolib.subsystems.HSFlywheel;

public class Shooter extends HSFlywheel {

    private static Shooter instance;

    private static TalonFX master;
    private static TalonFX follower;
    private static DoubleSolenoid solenoid;

    private static TalonFXInvertType masterInvert;
    private static TalonFXInvertType followerInvert;

    private static double WHEEL_DIAMETER;
    private static int TICKS_PER_REVOLUTION;
    private static double GEAR_RATIO;

    private Shooter() {

        super(RobotMap.CAN_IDS.SHOOTER_MASTER_ID, RobotMap.CAN_IDS.SHOOTER_FOLLOWER_ID, WHEEL_DIAMETER, TICKS_PER_REVOLUTION, GEAR_RATIO);

        solenoid = new DoubleSolenoid(RobotMap.CAN_IDS.SHOOTER_FORWARD_SOLENOID, RobotMap.CAN_IDS.SHOOTER_BACKWARD_SOLENOID);

        setupFlywheel();
    }

    public static Shooter getInstance() {
        if (instance == null)
            instance = new Shooter();
        return instance;
    }

    public void setupFlywheel() {
        super.setupFlywheel();  

    }

    public void spinShooterPercentOutput(double percentOutput) {

        super.spinShooterPercentOutput(percentOutput);

    }

    public void spinShooterVelocity(double velocity) {

        super.spinShooterVelocity(velocity);

    }

    public TalonFX getMaster() {
        return super.getMaster();
    }

    public TalonFX getFollower() {
        return super.getFollower();
    }


    
}