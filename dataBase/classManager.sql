--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

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

SET default_with_oids = false;

--
-- Name: Class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Class" (
    "ClassID" integer NOT NULL,
    "Place" character varying(50) NOT NULL,
    "TeacherID" integer NOT NULL,
    "DisciplineID" integer NOT NULL
);


ALTER TABLE public."Class" OWNER TO postgres;

--
-- Name: TABLE "Class"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Class" IS 'Order information
like Date, Amount';


--
-- Name: Class_ClassID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Class_ClassID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Class_ClassID_seq" OWNER TO postgres;

--
-- Name: Class_ClassID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Class_ClassID_seq" OWNED BY public."Class"."ClassID";


--
-- Name: Class_Student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Class_Student" (
    "Class_StudentID" integer NOT NULL,
    "Registration" bigint NOT NULL,
    "ClassID" integer NOT NULL
);


ALTER TABLE public."Class_Student" OWNER TO postgres;

--
-- Name: TABLE "Class_Student"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Class_Student" IS 'Order information
like Date, Amount';


--
-- Name: Class_Student_Class_StudentID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Class_Student_Class_StudentID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Class_Student_Class_StudentID_seq" OWNER TO postgres;

--
-- Name: Class_Student_Class_StudentID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Class_Student_Class_StudentID_seq" OWNED BY public."Class_Student"."Class_StudentID";


--
-- Name: Discipline; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Discipline" (
    "DisciplineID" integer NOT NULL,
    "DisciplineName" character varying(50) NOT NULL,
    "TeacherID" integer NOT NULL
);


ALTER TABLE public."Discipline" OWNER TO postgres;

--
-- Name: TABLE "Discipline"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Discipline" IS 'Basic information 
about Product';


--
-- Name: Discipline_DisciplineID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Discipline" ALTER COLUMN "DisciplineID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Discipline_DisciplineID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: Event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Event" (
    "EventID" integer NOT NULL,
    "EventName" character varying(50) NOT NULL,
    "EventDEescription" character varying(200),
    "Begin" timestamp without time zone NOT NULL,
    "End" timestamp without time zone NOT NULL,
    "Type" character varying(20) NOT NULL
);


ALTER TABLE public."Event" OWNER TO postgres;

--
-- Name: TABLE "Event"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Event" IS 'Information about
like Price, Quantity';


--
-- Name: Event_EventID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Event_EventID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Event_EventID_seq" OWNER TO postgres;

--
-- Name: Event_EventID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Event_EventID_seq" OWNED BY public."Event"."EventID";


--
-- Name: Matter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Matter" (
    "MatterID" integer NOT NULL,
    "Title" character varying(40) NOT NULL,
    "Subtitle" character varying(100),
    "DisciplineID" integer NOT NULL
);


ALTER TABLE public."Matter" OWNER TO postgres;

--
-- Name: TABLE "Matter"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Matter" IS 'Basic information 
about Supplier';


--
-- Name: Matter_MatterID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Matter_MatterID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Matter_MatterID_seq" OWNER TO postgres;

--
-- Name: Matter_MatterID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Matter_MatterID_seq" OWNED BY public."Matter"."MatterID";


--
-- Name: Student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Student" (
    "Registration" bigint NOT NULL,
    "StudentName" character varying(50) NOT NULL,
    "BeginContract" timestamp without time zone NOT NULL
);


ALTER TABLE public."Student" OWNER TO postgres;

--
-- Name: TABLE "Student"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Student" IS 'Basic information 
about Customer';


--
-- Name: Student_Registration_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Student_Registration_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Student_Registration_seq" OWNER TO postgres;

--
-- Name: Student_Registration_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Student_Registration_seq" OWNED BY public."Student"."Registration";


--
-- Name: Teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Teacher" (
    "TeacherID" integer NOT NULL,
    "TeacherName" character varying(40) NOT NULL,
    "BeginContract" timestamp without time zone NOT NULL
);


ALTER TABLE public."Teacher" OWNER TO postgres;

--
-- Name: TABLE "Teacher"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Teacher" IS 'Basic information 
about Supplier';


--
-- Name: Teacher_TeacherID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Teacher_TeacherID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Teacher_TeacherID_seq" OWNER TO postgres;

--
-- Name: Teacher_TeacherID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Teacher_TeacherID_seq" OWNED BY public."Teacher"."TeacherID";


--
-- Name: Class ClassID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class" ALTER COLUMN "ClassID" SET DEFAULT nextval('public."Class_ClassID_seq"'::regclass);


--
-- Name: Class_Student Class_StudentID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class_Student" ALTER COLUMN "Class_StudentID" SET DEFAULT nextval('public."Class_Student_Class_StudentID_seq"'::regclass);


--
-- Name: Event EventID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Event" ALTER COLUMN "EventID" SET DEFAULT nextval('public."Event_EventID_seq"'::regclass);


--
-- Name: Matter MatterID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Matter" ALTER COLUMN "MatterID" SET DEFAULT nextval('public."Matter_MatterID_seq"'::regclass);


--
-- Name: Student Registration; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Student" ALTER COLUMN "Registration" SET DEFAULT nextval('public."Student_Registration_seq"'::regclass);


--
-- Name: Teacher TeacherID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Teacher" ALTER COLUMN "TeacherID" SET DEFAULT nextval('public."Teacher_TeacherID_seq"'::regclass);


--
-- Name: Class PK_Class; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class"
    ADD CONSTRAINT "PK_Class" PRIMARY KEY ("ClassID");


--
-- Name: Class_Student PK_Class_Student; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class_Student"
    ADD CONSTRAINT "PK_Class_Student" PRIMARY KEY ("Class_StudentID");


--
-- Name: Discipline PK_Discipline; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Discipline"
    ADD CONSTRAINT "PK_Discipline" PRIMARY KEY ("DisciplineID");


--
-- Name: Event PK_Event; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Event"
    ADD CONSTRAINT "PK_Event" PRIMARY KEY ("EventID");


--
-- Name: Matter PK_Matter; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Matter"
    ADD CONSTRAINT "PK_Matter" PRIMARY KEY ("MatterID");


--
-- Name: Student PK_Student; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Student"
    ADD CONSTRAINT "PK_Student" PRIMARY KEY ("Registration");


--
-- Name: Teacher PK_Teacher; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Teacher"
    ADD CONSTRAINT "PK_Teacher" PRIMARY KEY ("TeacherID");


--
-- Name: fkClassID_Class_Student; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkClassID_Class_Student" ON public."Class_Student" USING btree ("ClassID");


--
-- Name: fkDiscipline; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkDiscipline" ON public."Discipline" USING btree ("TeacherID");


--
-- Name: fkDisciplineID_Class; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkDisciplineID_Class" ON public."Class" USING btree ("DisciplineID");


--
-- Name: fkMatter; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkMatter" ON public."Matter" USING btree ("DisciplineID");


--
-- Name: fkRegistration_Class_Student; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkRegistration_Class_Student" ON public."Class_Student" USING btree ("Registration");


--
-- Name: fkTeacherID_Class; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fkTeacherID_Class" ON public."Class" USING btree ("TeacherID");


--
-- Name: Class_Student FK_ClassID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class_Student"
    ADD CONSTRAINT "FK_ClassID" FOREIGN KEY ("ClassID") REFERENCES public."Class"("ClassID");


--
-- Name: Matter FK_Discipline; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Matter"
    ADD CONSTRAINT "FK_Discipline" FOREIGN KEY ("DisciplineID") REFERENCES public."Discipline"("DisciplineID");


--
-- Name: Class FK_DisciplineID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class"
    ADD CONSTRAINT "FK_DisciplineID" FOREIGN KEY ("DisciplineID") REFERENCES public."Discipline"("DisciplineID");


--
-- Name: Class_Student FK_Registration; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class_Student"
    ADD CONSTRAINT "FK_Registration" FOREIGN KEY ("Registration") REFERENCES public."Student"("Registration");


--
-- Name: Discipline FK_TeacheID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Discipline"
    ADD CONSTRAINT "FK_TeacheID" FOREIGN KEY ("TeacherID") REFERENCES public."Teacher"("TeacherID");


--
-- Name: Class FK_TeacherID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class"
    ADD CONSTRAINT "FK_TeacherID" FOREIGN KEY ("TeacherID") REFERENCES public."Teacher"("TeacherID");


--
-- PostgreSQL database dump complete
--

