import {Entity, PrimaryGeneratedColumn, ManyToOne, JoinColumn} from "typeorm";
import { Checklist } from "./Checklist";
import { Team } from "./Team";

@Entity({name: "team_checklists"})
export class TeamChecklist {

    @PrimaryGeneratedColumn()
    id: number;

    @ManyToOne(type => Checklist, checklist => checklist.teamChecklists)
    @JoinColumn({name: "checklist_id"})
    checklist: Checklist

    @ManyToOne(type => Team, team => team.teamChecklists)
    @JoinColumn({name: "team_id"})
    team: Team

}