import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn} from "typeorm";
import { Todo } from "./Todo";
import { User } from "./User";

@Entity({name: "user_todos"})
export class UserTodo {

    @PrimaryGeneratedColumn()
    id: number;

    @ManyToOne(type => Todo, todo => todo.userTodos)
    @JoinColumn({name: "todo_id"})
    todo: Todo

    @ManyToOne(type => User, user => user.userTodos)
    @JoinColumn({name: "user_id"})
    user: User

    @Column()
    assigned_date: string;

    @Column()
    completed_date: string;

    @Column()
    status: boolean;

}