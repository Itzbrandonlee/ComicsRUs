--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-09-14 22:15:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16480)
-- Name: collections; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.collections (
    collection_id integer NOT NULL,
    collection_name character varying(255),
    collection_privacy character varying(50) NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.collections OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16479)
-- Name: collections_collection_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collections_collection_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.collections_collection_id_seq OWNER TO postgres;

--
-- TOC entry 4860 (class 0 OID 0)
-- Dependencies: 217
-- Name: collections_collection_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collections_collection_id_seq OWNED BY public.collections.collection_id;


--
-- TOC entry 220 (class 1259 OID 16489)
-- Name: collections_comic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.collections_comic (
    collection_comic_id integer NOT NULL,
    collection_id integer NOT NULL,
    marvel_id integer NOT NULL,
    comic_title character varying(255) NOT NULL,
    description text,
    imageurl character varying(255),
    creator_id integer NOT NULL
);


ALTER TABLE public.collections_comic OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16488)
-- Name: collections_comic_collection_comic_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collections_comic_collection_comic_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.collections_comic_collection_comic_id_seq OWNER TO postgres;

--
-- TOC entry 4863 (class 0 OID 0)
-- Dependencies: 219
-- Name: collections_comic_collection_comic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collections_comic_collection_comic_id_seq OWNED BY public.collections_comic.collection_comic_id;


--
-- TOC entry 216 (class 1259 OID 16469)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    password_hash character varying(200) NOT NULL,
    role character varying(50) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16468)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 4866 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 4699 (class 2604 OID 16483)
-- Name: collections collection_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections ALTER COLUMN collection_id SET DEFAULT nextval('public.collections_collection_id_seq'::regclass);


--
-- TOC entry 4700 (class 2604 OID 16492)
-- Name: collections_comic collection_comic_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections_comic ALTER COLUMN collection_comic_id SET DEFAULT nextval('public.collections_comic_collection_comic_id_seq'::regclass);


--
-- TOC entry 4698 (class 2604 OID 16472)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 4708 (class 2606 OID 16496)
-- Name: collections_comic collections_comic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections_comic
    ADD CONSTRAINT collections_comic_pkey PRIMARY KEY (collection_comic_id);


--
-- TOC entry 4706 (class 2606 OID 16487)
-- Name: collections collections_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections
    ADD CONSTRAINT collections_pkey PRIMARY KEY (collection_id);


--
-- TOC entry 4702 (class 2606 OID 16474)
-- Name: users pk_user; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT pk_user PRIMARY KEY (user_id);


--
-- TOC entry 4704 (class 2606 OID 16476)
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 4710 (class 2606 OID 16497)
-- Name: collections_comic collections_comic_collection_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections_comic
    ADD CONSTRAINT collections_comic_collection_id_fkey FOREIGN KEY (collection_id) REFERENCES public.collections(collection_id) ON DELETE CASCADE;


--
-- TOC entry 4709 (class 2606 OID 16502)
-- Name: collections fk_user_collection; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collections
    ADD CONSTRAINT fk_user_collection FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- TOC entry 4859 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE collections; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.collections TO final_capstone_owner;
GRANT ALL ON TABLE public.collections TO final_capstone_appuser;


--
-- TOC entry 4861 (class 0 OID 0)
-- Dependencies: 217
-- Name: SEQUENCE collections_collection_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.collections_collection_id_seq TO final_capstone_owner;
GRANT SELECT,USAGE ON SEQUENCE public.collections_collection_id_seq TO final_capstone_appuser;


--
-- TOC entry 4862 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE collections_comic; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.collections_comic TO final_capstone_owner;
GRANT ALL ON TABLE public.collections_comic TO final_capstone_appuser;


--
-- TOC entry 4864 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE collections_comic_collection_comic_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.collections_comic_collection_comic_id_seq TO final_capstone_appuser;
GRANT SELECT,USAGE ON SEQUENCE public.collections_comic_collection_comic_id_seq TO final_capstone_owner;


--
-- TOC entry 4865 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO final_capstone_owner;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.users TO final_capstone_appuser;


--
-- TOC entry 4867 (class 0 OID 0)
-- Dependencies: 215
-- Name: SEQUENCE users_user_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.users_user_id_seq TO final_capstone_owner;
GRANT SELECT,USAGE ON SEQUENCE public.users_user_id_seq TO final_capstone_appuser;


-- Completed on 2024-09-14 22:15:54

--
-- PostgreSQL database dump complete
--

