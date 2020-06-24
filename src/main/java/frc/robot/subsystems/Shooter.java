package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;


public class Shooter extends SubsystemBase {

    private static Shooter instance;

    private static TalonFX master;
    private static TalonFX follower;
    private static DoubleSolenoid solenoid;

    private static TalonFXInvertType masterInvert;
    private static TalonFXInvertType followerInvert;

    private Shooter() {

        master = new TalonFX(RobotMap.CAN_IDS.SHOOTER_MASTER_ID);
        follower = new TalonFX(RobotMap.CAN_IDS.SHOOTER_FOLLOWER_ID);
        solenoid = new DoubleSolenoid(RobotMap.CAN_IDS.SHOOTER_FORWARD_SOLENOID, RobotMap.CAN_IDS.SHOOTER_BACKWARD_SOLENOID);

        setupFlywheel();
    }

    public static Shooter getInstance() {
        if (instance == null)
            instance = new Shooter();
        return instance;
    }

    public void setupFlywheel() {

        master.configFactoryDefault();
        follower.configFactoryDefault();

        follower.follow(master);

        master.setInverted(masterInvert);
        follower.setInverted(followerInvert);      

    }

    public void spinShooterPercentOutput(double percentOutput) {

        if(percentOutput == 0)
            master.set(ControlMode.Disabled, 0);
        else
            master.set(ControlMode.PercentOutput, percentOutput);

    }

    public void spinShooterVelocity(double velocity) {

    }

    
}