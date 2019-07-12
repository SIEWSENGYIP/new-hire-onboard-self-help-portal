import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { User } from "./User";
import { TeamChecklist } from "./TeamChecklist";

@Entity({name: "teams"})
export class Team {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @OneToMany(type => User, user => user.team)
    users: User[]

    @OneToMany(type => TeamChecklist, teamChecklist => teamChecklist.team)
    teamChecklists: TeamChecklist[]

}