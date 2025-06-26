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
package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.NewMecanumDrive;

@Config
@TeleOp(name = "testOpmode", group = "Test")
public class testOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        NewMecanumDrive drive = new NewMecanumDrive(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            drive.update();
            drive.updateOdo();
            drive.setFieldCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
}