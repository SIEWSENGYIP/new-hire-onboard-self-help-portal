import {MigrationInterface, QueryRunner} from "typeorm";

export class CreatedAllTables1562936436358 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "user_checklists" ("id" int NOT NULL IDENTITY(1,1), "checklist_id" int, "user_id" int, "assigned_date" nvarchar(255) NOT NULL, "completed_date" nvarchar(255) NOT NULL, "status" bit NOT NULL, CONSTRAINT "PK_4da21c2e04d84e46f1d6d034d5b" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "teams" ("id" int NOT NULL IDENTITY(1,1), "description" nvarchar(255) NOT NULL, CONSTRAINT "PK_7e5523774a38b08a6236d322403" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "team_checklists" ("id" int NOT NULL IDENTITY(1,1), "checklist_id" int, "team_id" int, CONSTRAINT "PK_be4a0a361ea5f298c238c7a9ea5" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "checklists" ("id" int NOT NULL IDENTITY(1,1), "item" nvarchar(255) NOT NULL, "description" nvarchar(255) NOT NULL, "category" nvarchar(255) NOT NULL, "url" nvarchar(255) NOT NULL, "reference_doc" nvarchar(255) NOT NULL, CONSTRAINT "PK_336ade2047f3d713e1afa20d2c6" PRIMARY KEY ("id"))`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "badge_id" int NOT NULL`);
        await queryRunner.query(`ALTER TABLE "users" ADD CONSTRAINT "UQ_36d964b64d4410778313a794ce7" UNIQUE ("badge_id")`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "joined_date" nvarchar(255)`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "manager_id" int`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "team_id" int`);
        await queryRunner.query(`ALTER TABLE "user_checklists" ADD CONSTRAINT "FK_45e13620a453e3cea6f3faf8412" FOREIGN KEY ("checklist_id") REFERENCES "checklists"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "user_checklists" ADD CONSTRAINT "FK_61bdf4b5926f94e36ebea407491" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "users" ADD CONSTRAINT "FK_1208ee1db5ddb64b48a86b46a61" FOREIGN KEY ("team_id") REFERENCES "teams"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "team_checklists" ADD CONSTRAINT "FK_b8bdf30c05581b440abf1c9ef17" FOREIGN KEY ("checklist_id") REFERENCES "checklists"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "team_checklists" ADD CONSTRAINT "FK_6e21ef9fca0ea631e03bc596c2d" FOREIGN KEY ("team_id") REFERENCES "teams"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "team_checklists" DROP CONSTRAINT "FK_6e21ef9fca0ea631e03bc596c2d"`);
        await queryRunner.query(`ALTER TABLE "team_checklists" DROP CONSTRAINT "FK_b8bdf30c05581b440abf1c9ef17"`);
        await queryRunner.query(`ALTER TABLE "users" DROP CONSTRAINT "FK_1208ee1db5ddb64b48a86b46a61"`);
        await queryRunner.query(`ALTER TABLE "user_checklists" DROP CONSTRAINT "FK_61bdf4b5926f94e36ebea407491"`);
        await queryRunner.query(`ALTER TABLE "user_checklists" DROP CONSTRAINT "FK_45e13620a453e3cea6f3faf8412"`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "team_id" int NOT NULL`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "manager_id" int NOT NULL`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "joined_date" nvarchar(255) NOT NULL`);
        await queryRunner.query(`ALTER TABLE "users" DROP CONSTRAINT "UQ_36d964b64d4410778313a794ce7"`);
        await queryRunner.query(`ALTER TABLE "users" ALTER COLUMN "badge_id" int NOT NULL`);
        await queryRunner.query(`DROP TABLE "checklists"`);
        await queryRunner.query(`DROP TABLE "team_checklists"`);
        await queryRunner.query(`DROP TABLE "teams"`);
        await queryRunner.query(`DROP TABLE "user_checklists"`);
    }

}
