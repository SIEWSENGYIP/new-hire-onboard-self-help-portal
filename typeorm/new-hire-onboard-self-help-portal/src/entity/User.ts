import {Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne, JoinColumn} from "typeorm";
import { Team } from "./Team";
import { UserChecklist } from "./UserChecklist";

@Entity({name: "users"})
export class User {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({ unique: true })
    badge_id: number;

    @Column()
    nt_name: string;

    @Column()
    email: string;

    @Column({ nullable: true })
    joined_date: string;

    @ManyToOne(type => Team, team => team.users)
    @JoinColumn({name: "team_id"})
    team: Team

    @Column({ nullable: true })
    manager_id: number;

    @Column({ nullable: false })
    user_role: string;

    @OneToMany(type => UserChecklist, userChecklist => userChecklist.user)
    userChecklists: UserChecklist[]
}