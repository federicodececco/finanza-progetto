-- Spring Boot import.sql file
-- Inserimento Categorie
INSERT INTO categories (id, name, description) VALUES (1, 'Investimenti a Reddito Fisso', 'Prodotti finanziari che offrono un rendimento prevedibile e costante nel tempo, generalmente considerati a basso rischio.');
INSERT INTO categories (id, name, description) VALUES (2, 'Investimenti Azionari', 'Prodotti finanziari che rappresentano una quota di proprietà in una società, offrendo potenziale di crescita elevato ma con rischio maggiore.');
INSERT INTO categories (id, name, description) VALUES (3, 'Fondi Bilanciati', 'Fondi comuni di investimento che combinano diverse classi di attività (azioni, obbligazioni, liquidità) per bilanciare rischio e rendimento.');

-- Inserimento Tag
INSERT INTO tags (id, name) VALUES (1, 'Crescita Capitale');
INSERT INTO tags (id, name) VALUES (2, 'Preservazione Capitale');
INSERT INTO tags (id, name) VALUES (3, 'Diversificazione');
INSERT INTO tags (id, name) VALUES (4, 'Lungo Termine');
INSERT INTO tags (id, name) VALUES (5, 'Breve Termine');
INSERT INTO tags (id, name) VALUES (6, 'Mercati Emergenti');
INSERT INTO tags (id, name) VALUES (7, 'Sostenibilità (ESG)');

-- Inserimento Prodotti (Concepts)
INSERT INTO concepts (id, category_id, name, level, description, full_description, img_url) VALUES (1, 1, 'Conto Deposito SicuroPlus', 'basso', 'Un conto deposito a basso rischio che offre un tasso di interesse garantito per un periodo determinato.', 'Il Conto Deposito SicuroPlus è la scelta ideale per chi cerca una soluzione di risparmio sicura e con un rendimento certo. Offre un tasso di interesse fisso e garantito per tutta la durata del vincolo, proteggendo il capitale investito. È perfetto per obiettivi a breve termine e per chi desidera preservare il proprio patrimonio senza esporsi a volatilità di mercato. Non prevede costi di apertura o gestione.', NULL);
INSERT INTO concepts (id, category_id, name, level, description, full_description, img_url) VALUES (2, 2, 'Azioni Global Innovators Growth', 'alto', 'Investimento in un paniere di azioni di società globali ad alto potenziale di crescita nel settore tecnologico e dell''innovazione.', 'Azioni Global Innovators Growth mira a cogliere le opportunità offerte dalle aziende che stanno definendo il futuro attraverso l''innovazione tecnologica. L''investimento si concentra su società leader nei settori dell''intelligenza artificiale, del cloud computing, delle biotecnologie e delle energie rinnovabili. Pur offrendo un elevato potenziale di rendimento, questo prodotto è soggetto a una significativa volatilità di mercato ed è consigliato per investitori con un orizzonte temporale di lungo periodo e un''alta propensione al rischio.', NULL);
INSERT INTO concepts (id, category_id, name, level, description, full_description, img_url) VALUES (3, 3, 'Fondo Equilibrio Dinamico', 'medio', 'Un fondo bilanciato che adatta la sua composizione tra azioni e obbligazioni in base alle condizioni di mercato.', 'Il Fondo Equilibrio Dinamico è progettato per offrire un bilanciamento ottimale tra crescita del capitale e controllo del rischio. Il gestore del fondo adatta attivamente l''allocazione tra diverse classi di attività, come azioni, obbligazioni e strumenti monetari, in risposta alle mutevoli condizioni economiche e di mercato. Questo approccio mira a massimizzare i rendimenti durante le fasi di mercato positive e a contenere le perdite durante quelle negative. Adatto a investitori con un profilo di rischio medio e un orizzonte temporale di medio-lungo periodo.', NULL);
INSERT INTO concepts (id, category_id, name, level, description, full_description, img_url) VALUES (4, 1, 'Obbligazione Corporate Europa AAA', 'basso', 'Investimento in obbligazioni emesse da società europee con il massimo rating creditizio (AAA).', 'L''Obbligazione Corporate Europa AAA offre un''opportunità di investimento a basso rischio, focalizzata su titoli di debito emessi da aziende europee solide e finanziariamente stabili, certificate con il più alto grado di affidabilità creditizia. Questo prodotto è ideale per chi cerca un flusso di reddito costante e una maggiore sicurezza del capitale investito, rappresentando una componente stabile per un portafoglio diversificato. La scadenza e il tasso cedolare sono predefiniti.', NULL);
INSERT INTO concepts (id, category_id, name, level, description, full_description, img_url) VALUES (5, 2, 'PAC Futuro Sostenibile', 'medio', 'Un Piano di Accumulo Capitale (PAC) che investe gradualmente in aziende con elevati standard di sostenibilità (ESG).', 'Il PAC Futuro Sostenibile permette di costruire valore nel tempo investendo in un portafoglio diversificato di aziende che dimostrano un forte impegno verso criteri ambientali, sociali e di governance (ESG). Attraverso versamenti periodici, anche di piccolo importo, si partecipa alla crescita di realtà aziendali attente all''impatto sul pianeta e sulla società. Questo prodotto è adatto a chi desidera un investimento etico e responsabile, con un orizzonte temporale di medio-lungo periodo e una propensione al rischio moderata, mitigata dalla gradualità dell''investimento tipica dei PAC.', NULL);

-- Inserimento Associazioni Concept-Tag (concept_tag)
-- Prodotto 1: Conto Deposito SicuroPlus (ID: 1)
INSERT INTO concept_tag (concept_id, tag_id) VALUES (1, 2);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (1, 5);

-- Prodotto 2: Azioni Global Innovators Growth (ID: 2)
INSERT INTO concept_tag (concept_id, tag_id) VALUES (2, 1);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (2, 4);

-- Prodotto 3: Fondo Equilibrio Dinamico (ID: 3)
INSERT INTO concept_tag (concept_id, tag_id) VALUES (3, 3);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (3, 4);

-- Prodotto 4: Obbligazione Corporate Europa AAA (ID: 4)
INSERT INTO concept_tag (concept_id, tag_id) VALUES (4, 2);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (4, 3);

-- Prodotto 5: PAC Futuro Sostenibile (ID: 5)
INSERT INTO concept_tag (concept_id, tag_id) VALUES (5, 1);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (5, 4);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (5, 7);
INSERT INTO concept_tag (concept_id, tag_id) VALUES (5, 3);

-- Inserimento faq della tabella faq
INSERT INTO faq (id, question) VALUES (1, 'Cos''è una piattaforma fintech e come funziona?');
INSERT INTO faq (id, question) VALUES (2, 'Quali sono i vantaggi di utilizzare un servizio fintech rispetto a una banca tradizionale?');
INSERT INTO faq (id, question) VALUES (3, 'Come garantite la sicurezza dei miei dati e dei miei fondi?');
INSERT INTO faq (id, question) VALUES (4, 'Quali sono le commissioni applicate sui servizi?');
INSERT INTO faq (id, question) VALUES (5, 'Quanto tempo ci vuole per aprire un conto e iniziare a operare?');
INSERT INTO faq (id, question) VALUES (6, 'Posso collegare più conti bancari alla piattaforma?');
INSERT INTO faq (id, question) VALUES (7, 'Come funziona l’assistenza clienti e in quali orari è disponibile?');

-- Inserimento answer della tabella answers
INSERT INTO answers (id, faq_id, content) VALUES (1, 1, 'Una piattaforma fintech (financial technology) utilizza tecnologie digitali avanzate per offrire servizi finanziari—come pagamenti, prestiti, investimenti e gestione del risparmio—in modo semplice, veloce e sicuro.');
INSERT INTO answers (id, faq_id, content) VALUES (2, 1, 'Gli utenti si registrano online, collegano i propri conti bancari o carte di pagamento e possono gestire tutte le operazioni dalla dashboard.');
INSERT INTO answers (id, faq_id, content) VALUES(3, 2, 'Velocità e semplicità: aperture di conti e transazioni completamente digitali, senza code allo sportello.');
INSERT INTO answers (id, faq_id, content) VALUES (4, 2, 'Costi ridotti: commissioni spesso inferiori grazie all''automazione dei processi.');
INSERT INTO answers (id, faq_id, content) VALUES (5, 2, 'Trasparenza: dashboard in tempo reale su movimenti, saldi e condizioni contrattuali.');
INSERT INTO answers (id, faq_id, content) VALUES (6, 2, 'Innovazione: accesso a strumenti di budgeting, risparmio automatizzato e robo-advisory.');
INSERT INTO answers (id, faq_id, content) VALUES (7, 3, 'Utilizziamo protocolli di crittografia avanzata (TLS 1.2+), autenticazione a più fattori (2FA/MFA) e server in data center certificati (ISO 27001).');
INSERT INTO answers (id, faq_id, content) VALUES (8, 3, 'I fondi dei clienti sono segregati in conti vincolati presso istituti bancari partner, garantendo che non vengano utilizzati per attività societarie.');
INSERT INTO answers (id, faq_id, content) VALUES (9, 4, 'Le commissioni variano in base al prodotto.');
INSERT INTO answers (id, faq_id, content) VALUES (10, 4, 'Apertura e mantenimento del conto: spesso gratuita o a canone ridotto.');
INSERT INTO answers (id, faq_id, content) VALUES (11, 4, 'Transazioni (bonifici, pagamenti internazionali): percentuale o fisso per operazione.');
INSERT INTO answers (id, faq_id, content) VALUES (12, 4, 'Servizi di investimento: commissione di gestione annua (tipicamente 0,2–0,5%) più eventuali costi di performance.');
INSERT INTO answers (id, faq_id, content) VALUES (13, 4, 'Tutti i costi sono sempre mostrati in modo trasparente prima della conferma di ogni operazione.');
INSERT INTO answers (id, faq_id, content) VALUES (14, 5, 'La registrazione online richiede in media 5–10 minuti.');
INSERT INTO answers (id, faq_id, content) VALUES (15, 5, 'Dopo aver caricato i documenti (carta d''identità o passaporto) e completato la verifica dell''identità, l''attivazione del conto avviene generalmente entro 24 ore lavorative.');
INSERT INTO answers (id, faq_id, content) VALUES (16, 6, 'Sì: puoi collegare conti correnti, carte di debito/credito e wallet digitali di diversi istituti.');
INSERT INTO answers (id, faq_id, content) VALUES (17, 7, 'Offriamo supporto multicanale via chat in-app, e-mail e telefono.');
INSERT INTO answers (id, faq_id, content) VALUES (18, 7, 'Chat e-mail: attiva 24/7, con tempi di risposta medi entro 2 ore.');
INSERT INTO answers (id, faq_id, content) VALUES (19, 7, 'Telefono: dal lunedì al venerdì, 9:00–18:00 CET.');
INSERT INTO answers (id, faq_id, content) VALUES (20, 7, 'Inoltre, nella sezione Help Center trovi guide dettagliate e tutorial su tutte le funzionalità.');