import {MigrationInterface, QueryRunner} from "typeorm";

export class InitialMigration1562923248582 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "users" ("id" int NOT NULL IDENTITY(1,1), "badge_id" int NOT NULL, "nt_name" nvarchar(255) NOT NULL, "email" nvarchar(255) NOT NULL, "joined_date" nvarchar(255) NOT NULL, "team_id" int NOT NULL, "manager_id" int NOT NULL, "user_role" nvarchar(255) NOT NULL, CONSTRAINT "PK_a3ffb1c0c8416b9fc6f907b7433" PRIMARY KEY ("id"))`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`DROP TABLE "users"`);
    }

}
