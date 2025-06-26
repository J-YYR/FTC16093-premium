//   ####    ###                                                                                              ###                ###
//   ####    ###                                                                                              ###                ###
//   ####    ###                      ###                                                                     ###                ###
//   #####   ###                      ###                                                                     ###
//   #####   ###                      ###                                                                     ###
//   ######  ###         #            ###                                            #                 ##     ###                                 ##           ##   ###
//   ######  ###      #######      ##########                   ###  ###  ###     #######        ########     ###    ####        ###        ### ######       ##########
//   ### ##  ###     #########     ##########                   ###  ###  ###    #########       ########     ###   ####         ###        ###########     ###########
//   ### ### ###     ###   ####       ###                        ### #### ###    ###   ####      ########     ###  ####          ###        #####   ###     ###  ####
//   ###  ## ###    ###     ###       ###                        ######## ##    ###     ###      ####         ### ###            ###        ####    ###     ###   ###
//   ###  ######    ###     ###       ###                        ##### #####    ###     ###      ###          ########           ###        ####    ###     ###   ###
//   ###  ######    ###     ###       ###                        ##### #####    ###     ###      ###          ########           ###        ###     ###     ########
//   ###   #####    ###     ###       ###                        ##### #####    ###     ###      ###          #### ####          ###        ###     ###     ########
//   ###   #####    ###     ###       ###                         #### ####     ###     ###      ###          ###   ###          ###        ###     ###     ######
//   ###    ####    ####   ####       ###    #                    #### ####     ####   ####      ###          ###    ###         ###        ###     ###    ########
//   ###    ####     #########        ########                    #### ####      #########       ###          ###    ####        ###        ###     ###     #########
//   ###    ####      #######          #######                    ####  ###       #######        ###          ###     ###        ###        ###     ###     ##########
//   ###     ###         ##              ###                       ##   ###          ##          ###          ###     ####       ###        ###     ###    ###     ###




package org.firstinspires.ftc.teamcode.commands;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.NewMecanumDrive;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class TeleOpDriveCommand extends CommandBase {
    private final NewMecanumDrive drive;
    private final DoubleSupplier forward;
    private final DoubleSupplier rotate;
    private final DoubleSupplier fun;
    private final BooleanSupplier shouldReset;
    private final BooleanSupplier shouldSlow;

    public TeleOpDriveCommand(
            NewMecanumDrive drive,
            DoubleSupplier forward,
            DoubleSupplier fun,
            DoubleSupplier rotate,
            BooleanSupplier shouldReset,
            BooleanSupplier shouldSlow) {
        this.drive = drive;
        this.forward = forward;
        this.rotate = rotate;
        this.fun = fun;
        this.shouldReset = shouldReset;
        this.shouldSlow = shouldSlow;


        //TODO: 重写NewMecanumDrive使得它成为一个subsystem
//        addRequirements(drive);
    }

    @Override
    public void execute() {
        if (shouldReset.getAsBoolean()) {
            drive.resetHeading();
        }

        double forwardValue = forward.getAsDouble();
        double funValue = fun.getAsDouble();
        double rotateValue = rotate.getAsDouble() * 0.8;

        if (shouldSlow.getAsBoolean()) {
            forwardValue *= 0.3;
            funValue *= 0.3;
            rotateValue *= 0.3;
        }

        //TODO:重写调用逻辑
//        drive.setFieldRelativeDrivePower(new Pose2d(forwardValue, funValue, rotateValue));
    }
}
