import {Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne, JoinColumn} from "typeorm";

@Entity({name: "users"})
export class User {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    badge_id: number;

    @Column()
    nt_name: string;

    @Column()
    email: string;

    @Column()
    joined_date: string;

    @Column()
    team_id: number;

    @Column()
    manager_id: number;

    @Column()
    user_role: string;
}