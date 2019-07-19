import {MigrationInterface, QueryRunner} from "typeorm";

export class InitialMigration1563506011325 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "team_todos" ("id" int NOT NULL IDENTITY(1,1), "todo_id" int, "team_id" int, CONSTRAINT "PK_43e48c4df0db11545a77ee1e231" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "todos" ("id" int NOT NULL IDENTITY(1,1), "item" nvarchar(255) NOT NULL, "description" nvarchar(255) NOT NULL, "category" nvarchar(255) NOT NULL, "url" nvarchar(255) NOT NULL, "reference_doc" nvarchar(255) NOT NULL, CONSTRAINT "PK_ca8cafd59ca6faaf67995344225" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "user_todos" ("id" int NOT NULL IDENTITY(1,1),  "todo_id" int, "user_id" int, "assigned_date" nvarchar(255) NOT NULL, "completed_date" nvarchar(255) NOT NULL, "status" bit NOT NULL, CONSTRAINT "PK_1566314d42aaca43b9f0f422df5" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "users" ("id" int NOT NULL IDENTITY(1,1), "badge_id" int NOT NULL, "nt_name" nvarchar(255) NOT NULL, "email" nvarchar(255) NOT NULL, "joined_date" nvarchar(255), "manager_id" int, "user_role" nvarchar(255) NOT NULL, "status" nvarchar(255), "team_id" int, CONSTRAINT "UQ_36d964b64d4410778313a794ce7" UNIQUE ("badge_id"), CONSTRAINT "PK_a3ffb1c0c8416b9fc6f907b7433" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "teams" ("id" int NOT NULL IDENTITY(1,1), "description" nvarchar(255) NOT NULL, CONSTRAINT "PK_7e5523774a38b08a6236d322403" PRIMARY KEY ("id"))`);
        await queryRunner.query(`ALTER TABLE "team_todos" ADD CONSTRAINT "FK_15d3f806922d3661fe8cefb735a" FOREIGN KEY ("todo_id") REFERENCES "todos"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "team_todos" ADD CONSTRAINT "FK_fbe376d72d37eb1441a32fd0437" FOREIGN KEY ("team_id") REFERENCES "teams"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "user_todos" ADD CONSTRAINT "FK_b3b8f09f4eb71b271c095c8d136" FOREIGN KEY ("todo_id") REFERENCES "todos"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "user_todos" ADD CONSTRAINT "FK_ed2cc562ad54fba9e8efb5e406b" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "users" ADD CONSTRAINT "FK_1208ee1db5ddb64b48a86b46a61" FOREIGN KEY ("team_id") REFERENCES "teams"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "users" DROP CONSTRAINT "FK_1208ee1db5ddb64b48a86b46a61"`);
        await queryRunner.query(`ALTER TABLE "user_todos" DROP CONSTRAINT "FK_ed2cc562ad54fba9e8efb5e406b"`);
        await queryRunner.query(`ALTER TABLE "user_todos" DROP CONSTRAINT "FK_b3b8f09f4eb71b271c095c8d136"`);
        await queryRunner.query(`ALTER TABLE "team_todos" DROP CONSTRAINT "FK_fbe376d72d37eb1441a32fd0437"`);
        await queryRunner.query(`ALTER TABLE "team_todos" DROP CONSTRAINT "FK_15d3f806922d3661fe8cefb735a"`);
        await queryRunner.query(`DROP TABLE "teams"`);
        await queryRunner.query(`DROP TABLE "users"`);
        await queryRunner.query(`DROP TABLE "user_todos"`);
        await queryRunner.query(`DROP TABLE "todos"`);
        await queryRunner.query(`DROP TABLE "team_todos"`);
    }

}
