-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jul 12, 2020 at 10:38 AM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `BDOutoevaluation`
--

-- --------------------------------------------------------

--
-- Table structure for table `affictation_questions`
--

CREATE TABLE `affictation_questions` (
  `questionnaire_id_questionnaire` int(11) NOT NULL,
  `questionss_id_question` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `affictation_questions`
--

INSERT INTO `affictation_questions` (`questionnaire_id_questionnaire`, `questionss_id_question`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 6),
(2, 7),
(2, 9),
(3, 1),
(3, 2),
(3, 6),
(8, 5);

-- --------------------------------------------------------

--
-- Table structure for table `affictation_user`
--

CREATE TABLE `affictation_user` (
  `user_user_id` int(11) NOT NULL,
  `questionnaires_id_questionnaire` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `affictation_user`
--

INSERT INTO `affictation_user` (`user_user_id`, `questionnaires_id_questionnaire`) VALUES
(1, 1),
(1, 2),
(1, 6),
(2, 1),
(2, 2),
(2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `nom_categorie` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom_categorie`) VALUES
(1, 'Spring Boot'),
(2, 'Devops');

-- --------------------------------------------------------

--
-- Table structure for table `choixreponse`
--

CREATE TABLE `choixreponse` (
  `id_choix` int(11) NOT NULL,
  `bonne_reponse` varchar(255) DEFAULT NULL,
  `choix` varchar(255) DEFAULT NULL,
  `id_question` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `choixreponse`
--

INSERT INTO `choixreponse` (`id_choix`, `bonne_reponse`, `choix`, `id_question`) VALUES
(1, 'NON_VALIDE', 'dsfdsfdsf', 1),
(2, 'VALIDE', 'dfssdfdfssdfsdfdfsdf', 1),
(3, 'NON_VALIDE', 'dsfdsfdfsdsfdsf', 1),
(4, 'VALIDE', 'Design Pattern', 1),
(5, 'NON-VALIDE', 'Framework', 1),
(6, 'NON-VALIDE', 'Module Java', 1),
(7, 'NON-VALIDE', 'Abstrait', 2),
(8, 'VALIDE', 'Singleton', 2),
(9, 'NON-VALIDE', 'AOP', 3),
(10, 'VALIDE', 'HTML/JSP', 3),
(11, 'NON-VALIDE', 'ApplicationContext implémente le BeanFactory', 4),
(12, 'VALIDE', 'ApplicationContext hérite de BeanFactory', 4),
(13, 'NON-VALIDE', 'Utiliser un nouveau mot clé', 5),
(14, 'VALIDE', 'Utilisation de l’injection de dépendances de Spring', 5),
(15, 'NON-VALIDE', 'Lean Manufacturing.', 6),
(16, 'VALIDE', 'Waterfall Software Delivery.', 6),
(17, 'NON-VALIDE', 'Because they come from different backgrounds.', 7),
(18, 'VALIDE', ' Because they have conflicting business goals and priorities.', 7),
(19, 'VALIDE', 'aaaa', 16);

-- --------------------------------------------------------

--
-- Table structure for table `fonction`
--

CREATE TABLE `fonction` (
  `id_fonction` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fonction`
--

INSERT INTO `fonction` (`id_fonction`, `libelle`, `description`) VALUES
(7, 'developpeur web', NULL),
(3, 'd�veloppeur jee', NULL),
(5, 'chef departement ', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `questionnaire`
--

CREATE TABLE `questionnaire` (
  `id_questionnaire` int(11) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questionnaire`
--

INSERT INTO `questionnaire` (`id_questionnaire`, `titre`, `date`) VALUES
(1, 'DEVOPS', NULL),
(2, 'SPRINGBOOT', NULL),
(3, 'cdsfsdfsdfsd', NULL),
(4, 'fffff', NULL),
(5, 'rfgertgtrgtrg', NULL),
(6, 'fgdfgfgd', '2020/07/01 11:35:09'),
(7, 'azedrfgggggggg', '2020/07/01 11:35:25'),
(8, 'Quest2020', '2020/07/10 13:58:09'),
(9, 'ghhgghghgh', '2020/07/10 17:27:19');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id_question` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `created__date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id_question`, `date`, `libelle`, `id_categorie`, `id_type`, `created__date`) VALUES
(1, '2020-06-01 00:00:00', 'L’injection de dépendance ou IOC est un ', 1, 2, NULL),
(2, '2020-06-08 00:00:00', 'Les Beans définis dans le framework spring sont par défaut ', 1, 2, NULL),
(3, '2020-06-03 00:00:00', 'Lequel des éléments suivants n’est pas un module de Spring ?', 1, 2, NULL),
(4, '2020-06-02 00:00:00', 'Lequel des énoncés suivants est vrai ?', 1, 2, NULL),
(5, '2020-06-02 00:00:00', 'Lequel des énoncés suivants est vrai ?', 1, 2, NULL),
(6, '2020-06-01 00:00:00', 'Which one of the following methodologies does least impact the establishment of DevOps methodology?\r\n', 2, 2, NULL),
(7, '2020-06-01 00:00:00', 'In typical IT organizations why is there a typical conflict between development and operations teams?', 2, 2, NULL),
(8, '2020-06-02 00:00:00', 'Which one of the following techniques makes DevOps a successful methodology to develop and deliver ', 2, 2, NULL),
(9, '2020-06-01 00:00:00', 'Which one of the following statements about DevOps is incorrect?', 2, 2, NULL),
(10, '2020-06-01 00:00:00', 'How does a DevOps organization act in principle when it comes to financing its work?', 2, 2, NULL),
(11, NULL, 'dfgfgdfgfdgfgd', 1, 2, NULL),
(12, NULL, 'rtetretret', 1, 2, NULL),
(13, NULL, 'dfsdsdfsdf', 1, 2, NULL),
(14, '2020-07-06 00:00:00', 'sdfsdfsdf', 1, 2, NULL),
(15, '2020-07-01 14:50:58', 'erzezrezrerzrezerzerzrezrez', 1, 2, NULL),
(16, '2020-07-10 13:49:46', 'Etes-vous satisfait ?', 1, 2, NULL),
(17, '2020-07-11 14:07:00', 'rezreerzzerez?', 1, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

CREATE TABLE `reponse` (
  `id_reponse` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_questionnaire` int(11) DEFAULT NULL,
  `id_question` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `id_user`, `id_questionnaire`, `id_question`) VALUES
(37, 2, 2, 7);

-- --------------------------------------------------------

--
-- Table structure for table `reponse_choiser`
--

CREATE TABLE `reponse_choiser` (
  `reponse_id_reponse` int(11) NOT NULL,
  `choixreponse_id_choix` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id_type` int(11) NOT NULL,
  `nom_type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id_type`, `nom_type`) VALUES
(2, 'aaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email_user` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nom_user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom_user` varchar(255) DEFAULT NULL,
  `telephon` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id_fonction` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email_user`, `enabled`, `nom_user`, `password`, `prenom_user`, `telephon`, `username`, `id_fonction`) VALUES
(1, 'james@jelts.com', b'1', 'james', '$2a$10$ozNva7dplKjNSdb0uskYGOSAr1Yz8PHMflLTCU.U72ODRB1nxsBkq', 'jets', 23456789, 'james', 3),
(2, 'paula@paulsen.net', b'1', 'Paula', '$2a$10$IFE21zX7Mu8SbYyGhBuFmebh4TUQ7LZXMfwvaCzfSxLXuux17iCo.', 'Paulsen', 23456780, 'paula', 3),
(3, 'potter1@gmail.com', NULL, 'Potter', '$2a$10$W.RyMndj/yXYoqXGTDZ7K.5BL6ScIqYNR3hfjxACgnMHpgSacDveC', 'Polly', 23415678, 'polly', 5),
(5, 'dddd@gmail.com', b'1', 'frrfrfrf', '$2a$10$zc60.9NgLwwhViXxfRWPdurM9Nl5LU3l2U9kutsWL.Wj0wvs5zlkm', 'rfrrf', 23456778, 'rfr@ede.fr', 7),
(6, 'ededed@sdsdsd.fr', b'1', 'eddedeed', '$2a$10$GcwFLpTqPaRzsTzUAzZwZuK5vnKOUS6OMJg2yXfHmCRBcG0QjMMVe', 'deede', 124355677, 'deeded', 7);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(5, 1),
(6, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `affictation_questions`
--
ALTER TABLE `affictation_questions`
  ADD PRIMARY KEY (`questionnaire_id_questionnaire`,`questionss_id_question`),
  ADD KEY `FK2h9o8ubi486avcc88cqwvckso` (`questionss_id_question`);

--
-- Indexes for table `affictation_user`
--
ALTER TABLE `affictation_user`
  ADD PRIMARY KEY (`user_user_id`,`questionnaires_id_questionnaire`),
  ADD KEY `FK7agodo7kkpjvmb64761s5x2qh` (`questionnaires_id_questionnaire`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Indexes for table `choixreponse`
--
ALTER TABLE `choixreponse`
  ADD PRIMARY KEY (`id_choix`),
  ADD KEY `FK8ma3sxnytwpsba8sdhf42n1hf` (`id_question`);

--
-- Indexes for table `fonction`
--
ALTER TABLE `fonction`
  ADD PRIMARY KEY (`id_fonction`);

--
-- Indexes for table `questionnaire`
--
ALTER TABLE `questionnaire`
  ADD PRIMARY KEY (`id_questionnaire`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id_question`),
  ADD KEY `FKrcytctaicq4vd9nim444po2uh` (`id_categorie`),
  ADD KEY `FKb1em6xdovnii31g5wwt33lj89` (`id_type`);

--
-- Indexes for table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`),
  ADD KEY `FKf7n1jf6lypo80bt10m9c4n680` (`id_user`),
  ADD KEY `FKlxnaxvwnett909sa27j15q1r4` (`id_questionnaire`),
  ADD KEY `FKqln7hlrx756ahcl6q4gomuphd` (`id_question`);

--
-- Indexes for table `reponse_choiser`
--
ALTER TABLE `reponse_choiser`
  ADD PRIMARY KEY (`reponse_id_reponse`,`choixreponse_id_choix`),
  ADD KEY `FK3d4x5377wq13a0pi6oe4kr5np` (`choixreponse_id_choix`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_sgpbvva83aaeroqfb77028a38` (`email_user`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  ADD KEY `FKiihqxgd9medsvgr3o4qrbhk92` (`id_fonction`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `choixreponse`
--
ALTER TABLE `choixreponse`
  MODIFY `id_choix` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `fonction`
--
ALTER TABLE `fonction`
  MODIFY `id_fonction` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `questionnaire`
--
ALTER TABLE `questionnaire`
  MODIFY `id_questionnaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id_question` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;