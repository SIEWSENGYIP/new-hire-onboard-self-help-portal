import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn} from "typeorm";
import { Checklist } from "./Checklist";
import { User } from "./User";

@Entity({name: "user_checklists"})
export class UserChecklist {

    @PrimaryGeneratedColumn()
    id: number;

    @ManyToOne(type => Checklist, checklist => checklist.userChecklists)
    @JoinColumn({name: "checklist_id"})
    checklist: Checklist

    @ManyToOne(type => User, user => user.userChecklists)
    @JoinColumn({name: "user_id"})
    user: User

    @Column()
    assigned_date: string;

    @Column()
    completed_date: string;

    @Column()
    status: boolean;

}