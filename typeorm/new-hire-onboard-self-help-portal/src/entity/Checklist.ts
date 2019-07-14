import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { TeamChecklist } from "./TeamChecklist";
import { UserChecklist } from "./UserChecklist";

@Entity({name: "checklists"})
export class Checklist {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    item: string;

    @Column()
    description: string;

    @Column()
    category: string;

    @Column()
    url: string;

    @Column()
    reference_doc: string;

    @OneToMany(type => TeamChecklist, teamChecklist => teamChecklist.checklist)
    teamChecklists: TeamChecklist[]

    @OneToMany(type => UserChecklist, userChecklist => userChecklist.checklist)
    userChecklists: UserChecklist[]

}