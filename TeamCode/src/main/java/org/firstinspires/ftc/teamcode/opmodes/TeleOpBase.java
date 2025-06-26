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
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.NewMecanumDrive;

@Config
@TeleOp(name = "16093 TeleOp", group = "Competition")
public class TeleOpBase extends CommandOpMode {
    private GamepadEx gamepadEx1;
    @Override
    public void initialize() {
        CommandScheduler.getInstance().cancelAll();
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        gamepadEx1 = new GamepadEx(gamepad1);
    }
    @Override
    public void run(){
        CommandScheduler.getInstance().run();
        NewMecanumDrive drive = new NewMecanumDrive(hardwareMap);
        drive.update();
        drive.updateOdo();
        drive.setFieldCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}