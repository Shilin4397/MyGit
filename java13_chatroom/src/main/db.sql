create database java13_chatroom;

use java13_chatroom;

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    name varchar(50) unique,
    password varchar(50),
    nickName varchar(50),
    lastLogout datetime --表示上次退出的时间
);

drop  table if exists channel;
create table channel (
    channelId int primary key auto_increment,
    channelName varchar (50)
);

drop table if exists message;
create table message(
    messageId int primary key auto_increment,
    userId int, --发送者
    channelId int,
    content text, --消息正文
    sendTime datetime -- 消息发送时间
);