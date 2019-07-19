import {MigrationInterface, QueryRunner} from "typeorm";

export class EditedUser1563503309825 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "users" ADD "status" nvarchar(255) NOT NULL`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "users" DROP COLUMN "status"`);
    }

}
