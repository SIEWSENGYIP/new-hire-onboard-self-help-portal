import {Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne, JoinColumn} from "typeorm";
import { Team } from "./Team";
import { UserTodo } from "./UserTodo";

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

    @ManyToOne(type => Team, team => team.users, {nullable: true})
    @JoinColumn({name: "team_id"})
    team: Team

    @Column({ nullable: true })
    manager_id: number;

    @Column({ nullable: false })
    user_role: string;

    @Column({ nullable: true })
    status: string;

    @OneToMany(type => UserTodo, userTodo => userTodo.user)
    userTodos: UserTodo[]
}