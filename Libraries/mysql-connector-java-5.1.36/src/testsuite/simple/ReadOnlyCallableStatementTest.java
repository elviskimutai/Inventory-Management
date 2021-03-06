IqLmNsb3VkLmdvb2dsZS5jb22CFiouZ29vZ2xlLWFuYWx5dGljcy5jb22CCyouZ29vZ2xlLmNhggsqLmdvb2dsZS5jbIIOKi5nb29nbGUuY28uaW6CDiouZ29vZ2xlLmNvLmpwgg4qLmdvb2dsZS5jby51a4IPKi5nb29nbGUuY29tLmFygg8qLmdvb2dsZS5jb20uYXWCDyouZ29vZ2xlLmNvbS5icoIPKi5nb29nbGUuY29tLmNvgg8qLmdvb2dsZS5jb20ubXiCDyouZ29vZ2xlLmNvbS50coIPKi5nb29nbGUuY29tLnZuggsqLmdvb2dsZS5kZYILKi5nb29nbGUuZXOCCyouZ29vZ2xlLmZyggsqLmdvb2dsZS5odYILKi5nb29nbGUuaXSCCyouZ29vZ2xlLm5sggsqLmdvb2dsZS5wbIILKi5nb29nbGUucHSCEiouZ29vZ2xlYWRhcGlzLmNvbYIPKi5nb29nbGVhcGlzLmNughQqLmdvb2dsZWNvbW1lcmNlLmNvbYIRKi5nb29nbGV2aWRlby5jb22CDCouZ3N0YXRpYy5jboINKi5nc3RhdGljLmNvbYIKKi5ndnQxLmNvbYIKKi5ndnQyLmNvbYIUKi5tZXRyaWMuZ3N0YXRpYy5jb22CDCoudXJjaGluLmNvbYIQKi51cmwuZ29vZ2xlLmNvbYIWKi55b3V0dWJlLW5vY29va2llLmNvbYINKi55b3V0dWJlLmNvbYIWKi55b3V0dWJlZWR1Y2F0aW9uLmNvbYILKi55dGltZy5jb22CC2FuZHJvaWQuY29tggRnLmNvggZnb28uZ2yCFGdvb2dsZS1hbmFseXRpY3MuY29tggpnb29nbGUuY29tghJnb29nbGVjb21tZXJjZS5jb22CCnVyY2hpbi5jb22CCHlvdXR1LmJlggt5b3V0dWJlLmNvbYIUeW91dHViZWVkdWNhdGlvbi5jb20wCwYDVR0PBAQDAgeAMGgGCCsGAQUFBwEBBFwwWjArBggrBgEFBQcwAoYfaHR0cDovL3BraS5nb29nbGUuY29tL0dJQUcyLmNydDArBggrBgEFBQcwAYYfaHR0cDovL2NsaWVudHMxLmdvb2dsZS5jb20vb2NzcDAdBgNVHQ4EFgQUgQTZKbfu4VSTcqeT7XWJ2AgR+0cwDAYDVR0TAQH/BAIwADAfBgNVHSMEGDAWgBRK3QYWG7z2aLV29YG2u2IaulqBLzAhBgNVHSAEGjAYMAwGCisGAQQB1nkCBQEwCAYGZ4EMAQICMDAGA1UdHwQpMCcwJaAjoCGGH2h0dHA6Ly9wa2kuZ29vZ2xlLmNvbS9HSUFHMi5jcmwwDQYJKoZIhvcNAQELBQADggEBAGUe21Xl3pC3g9iajajNYKuvn6NEiqtQFWQrkizoJ3itpEdJfEPG4QxNpV1jBqp8BwTQ3bdzSC9VWAk8QK0A55rSqwlRErxUzbFaZnI7vE+C0VgMXxa1kSlvh30hmAc+0ovvvc3EwAzHoJ9I1YF+EGir0t95KJMjDxH/Mtv2efsrL4vcz4j2f9Rq+9f6ZakTBH7iJyk7SWS7clvD9HQ7vu13g9FkBi+KuTyrItgjEFNFalpdaHrliRG/51G+VE9bYk4JRP6sr1Fu3br5FxKOS1xua14MIogKN55YVNaEOqriAKegN/qBtkRb+zi92w7nOc5wCXlNxl0Es3HBUcPhE38AAACAAAAAgAAAACdUTFNfRUNESEVfRUNEU0FfV0lUSF9BRVNfMTI4X0dDTV9TSEEyNTYAAAABAA== request-method GET response-head HTTP/1.1 200 OK
Content-Type: image/jpeg
Date: Wed, 30 Sep 2015 20:57:29 GMT
Expires: Wed, 30 Sep 2015 21:02:29 GMT
Etag: "1443644598"
x-content-type-options: nosniff
Server: sffe
Content-Length: 3214
X-XSS-Protection: 1; mode=block
Age: 99
Cache-Control: public, max-age=300
X-Firefox-Spdy: 3.1
   �                                                                                                                                                                                                                                                                                                                                                                                                                                }
        }
    }

    public void testNotReadOnlyWithProcBodyAccess() throws Exception {
        if (versionMeetsMinimum(5, 0)) {

            Connection replConn = null;
            Properties props = getMasterSlaveProps();
            props.setProperty("autoReconnect", "true");

            try {
                createProcedure("testProc2", "()\nMODIFIES SQL DATA\nbegin\nSELECT NOW();\nend\n");

                createProcedure("`testProc.2`", "()\nMODIFIES SQL DATA\nbegin\nSELECT NOW();\nend\n");

                replConn = getMasterSlaveReplicationConnection();
                replConn.setReadOnly(true);

                CallableStatement cstmt = replConn.prepareCall("CALL testProc2()");

                try {
                    cstmt.execute();
                    fail("Should not execute because procedure modifies data.");
                } catch (SQLException e) {
                    assertEquals("Should error for read-only connection.", e.getSQLState(), "S1009");
                }

                cstmt = replConn.prepareCall("CALL `" + replConn.getCatalog() + "`.testProc2()");

                try {
                    cstmt.execute();
                    fail("Should not execute because procedure modifies data.");
                } catch (SQLException e) {
                    assertEquals("Should error for read-only connection.", e.getSQLState(), "S1009");
                }

                cstmt = replConn.prepareCall("CALL `" + replConn.getCatalog() + "`.`testProc.2`()");

                try {
                    cstmt.execute();
                    fail("Should not execute because procedure modifies data.");
                } catch (SQLException e) {
                    assertEquals("Should error for read-only connection.", e.getSQLState(), "S1009");
                }

            } finally {

                if (replConn != null) {
                    replConn.close();
                }
            }
        }
    }

}
