import {MigrationInterface, QueryRunner} from "typeorm";

export class FirstMigration1565083300069 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "user_todos" ALTER COLUMN "completed_date" nvarchar(255)`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "user_todos" ALTER COLUMN "completed_date" nvarchar(255) NOT NULL`);
    }

}
