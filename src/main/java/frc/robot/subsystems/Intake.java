package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    

    CANSparkMax intakeMotor;
    public Intake(){
        intakeMotor = new CANSparkMax(43, CANSparkMax.MotorType.kBrushless);
    }


    public void intake(){
        intakeMotor.set(.3);
    }
    public void rest(){
        intakeMotor.set(0);
    }
    public void outtake(){
        intakeMotor.set(-.15);
    }



    public Command getRunIntakeCommand(){
        return this.startEnd(()->intake(), ()->rest());
    }
    public Command getRunOutakeCommand (){
        return this.startEnd(() ->outtake(), ()->rest());
    }

    public Command getStopCommand() {
        return this.runOnce(() -> {this.rest();});
      }

}
