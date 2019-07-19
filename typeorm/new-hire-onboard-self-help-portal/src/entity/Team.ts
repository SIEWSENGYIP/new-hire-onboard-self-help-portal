import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { User } from "./User";
import { TeamTodo } from "./TeamTodo";

@Entity({name: "teams"})
export class Team {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @OneToMany(type => User, user => user.team)
    users: User[]

    @OneToMany(type => TeamTodo, teamTodo => teamTodo.team)
    teamTodos: TeamTodo[]

}