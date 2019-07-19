import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { TeamTodo } from "./TeamTodo";
import { UserTodo } from "./UserTodo";

@Entity({name: "todos"})
export class Todo {

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

    @OneToMany(type => TeamTodo, teamTodo => teamTodo.todo)
    teamTodos: TeamTodo[]

    @OneToMany(type => UserTodo, userTodo => userTodo.todo)
    userTodos: UserTodo[]

}